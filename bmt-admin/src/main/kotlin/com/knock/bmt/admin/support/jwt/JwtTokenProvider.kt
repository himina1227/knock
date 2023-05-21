package com.knock.bmt.admin.support.jwt

import com.knock.bmt.admin.support.PrincipalDetails
import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SecurityException
import jakarta.annotation.PostConstruct
import jakarta.servlet.http.HttpServletRequest
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.security.Key
import java.util.*
import java.util.stream.Collectors


@Component
class JwtTokenProvider {
    private val logger = KotlinLogging.logger { JwtTokenProvider() }
    @Value("\${jwt.access-token-validity-in-seconds}")
    private val accessExpiredTime: Long = 0
    @Value("\${jwt.refresh-token-validity-in-seconds}")
    private val refreshExpiredTime: Long = 0
    @Value("\${jwt.access-secret}")
    private var accessSecret: String? = null
    @Value("\${jwt.refresh-secret}")
    private var refreshSecret: String? = null
    private var accessKey: Key? = null
    private var refreshKey: Key? = null
    val issuer = "Bmt Auth-Server"

    @PostConstruct
    protected fun init() {
        this.accessKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(accessSecret))
        this.refreshKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(refreshSecret))
    }

    private fun createToken(loginId: String, payload: PayloadDto, validity: Date, signKey: Key?): String? {
        return Jwts.builder()
            .setClaims(payload.toMap())
            .setSubject(loginId)
            .signWith(signKey, SignatureAlgorithm.HS512)
            .setExpiration(validity)
            .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader(AUTHORIZATION_HEADER)
        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7)
        } else null
    }

    fun createAccessToken(authentication: Authentication): String? {
        var user: PrincipalDetails? = null
        if (authentication.principal is PrincipalDetails) {
            user = authentication.principal as PrincipalDetails
        }
        val payloadDto = PayloadDto.of(
            user?.userId,
            user?.loginId,
            user?.userRoleType?.name
        )
        val now = Date().time
        val validity: Date = Date(now + this.accessExpiredTime)
        return user?.username?.let { createToken(it, payloadDto, validity, accessKey) }
    }

    fun getAuthentication(token: String?): Authentication? {
        val claims = Jwts
            .parserBuilder()
            .setSigningKey(accessKey)
            .build()
            .parseClaimsJws(token)
            .body
        val authorities: Collection<GrantedAuthority?> =
            Arrays.stream(claims["role"].toString().split(",".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray())
                .map { role: String? ->
                    SimpleGrantedAuthority(
                        role
                    )
                }
                .collect(Collectors.toList())
        val principal = User(claims.subject, "", authorities)
        return UsernamePasswordAuthenticationToken(principal, token, authorities)
    }

    fun getUserIdFromJwtToken(jwt: String?): String? {
        return Jwts.parserBuilder().setSigningKey(accessKey).build().parseClaimsJws(jwt).body.subject
    }

    fun getClaimsFromJwtToken(jwt: String): Claims? {
        return if (validateToken(accessKey, jwt)) Jwts.parserBuilder().setSigningKey(accessKey).build()
            .parseClaimsJws(jwt).body else null
    }

    fun validateAccessToken(token: String): Boolean {
        return validateToken(accessKey, token)
    }

    fun validateToken(key: Key?, token: String): Boolean {
        return try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            true
        } catch (e: SecurityException) {
            throw RuntimeException("잘못된 JWT 서명입니다.")
        } catch (e: MalformedJwtException) {
            throw RuntimeException("잘못된 JWT 서명입니다.")
        } catch (e: ExpiredJwtException) {
            throw RuntimeException("만료된 JWT 토큰입니다.")
        } catch (e: UnsupportedJwtException) {
            throw RuntimeException("지원되지 않는 JWT 토큰입니다.")
        } catch (e: IllegalArgumentException) {
            throw RuntimeException("JWT 토큰이 잘못되었습니다.")
        }
    }

    internal class PayloadDto(val userId: Long?,val loginId: String?,val role: String?) {
        fun toMap(): Map<String, Any?> {
            val map: MutableMap<String, Any?> = HashMap()
            map["userId"] = userId
            map["loginId"] = loginId
            map["role"] = role
            return map
        }

        companion object {
            fun of(userId: Long?, loginId: String?, role: String?): PayloadDto {
                return PayloadDto(
                    userId = userId,
                    loginId = loginId,
                    role = role
                )
            }
        }
    }

    companion object {
        const val AUTHORIZATION_HEADER: String = "Authorization"
    }
}
