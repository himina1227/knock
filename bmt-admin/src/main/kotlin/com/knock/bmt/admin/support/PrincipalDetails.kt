package com.knock.bmt.admin.support

import com.knock.bmt.common.enums.UserRoleType
import org.springframework.security.core.CredentialsContainer
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.util.Assert
import java.util.*
import java.util.stream.Collectors

class PrincipalDetails : UserDetails, CredentialsContainer {
    private var role: String? = null
    val userId: Long? = null
    val loginId: String? = null

    override fun getPassword(): String? {
        return null
    }

    override fun getUsername(): String {
        return loginId!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun eraseCredentials() {}
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return Arrays.stream(role!!.split(",".toRegex())
            .dropLastWhile { it.isEmpty() }
            .toTypedArray())
            .map { role: String? ->
                SimpleGrantedAuthority(
                    role
                )
            }
            .collect(Collectors.toList())
    }

    val parsedUserId: Long
        get() {
            return userId!!.toLong()
        }
    val userRoleType: UserRoleType
        get() {
            return UserRoleType.ofCode(role)
        }
}