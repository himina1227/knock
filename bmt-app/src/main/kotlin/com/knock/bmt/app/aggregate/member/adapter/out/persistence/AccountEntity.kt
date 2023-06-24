package com.knock.bmt.app.aggregate.member.adapter.out.persistence

import com.knock.bmt.common.enums.UserRoleType
import jakarta.persistence.*
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy
import java.time.LocalDateTime

@Entity(name = "member")
class AccountEntity(
    id: Long? = null,
    loginId: String? = null,
    password: String? = null,
    userRoleType: UserRoleType = UserRoleType.GUEST,
    refreshToken: String? = null,
    temporarily: Boolean = false,
    kakaoId: String? = null,
    name: String? = null,
    disabled: Boolean = false,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = id

    val loginId: String? = loginId

    val password: String? = password

    val userRoleType: UserRoleType = userRoleType

    val refreshToken: String? = refreshToken

    val temporarily: Boolean = temporarily

    val kakaoId: String? = kakaoId

    val name: String? = name

    val disabled: Boolean = disabled
}