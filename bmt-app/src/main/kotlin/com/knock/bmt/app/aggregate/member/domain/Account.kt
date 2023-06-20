package com.knock.bmt.app.aggregate.member.domain

import com.knock.bmt.common.enums.UserRoleType
import java.time.LocalDateTime

class Account(
    id: Long? = null,
    loginId: String? = null,
    password: String? = null,
    passwordUpdatedAt: LocalDateTime? = null,
    userRoleType: UserRoleType = UserRoleType.GUEST,
    refreshToken: String? = null,
    temporarily: Boolean = false,
    kakaoId: String? = null,
    lastSigninSocialService: String? = null,
    name: String? = null,
    birthday: String? = null,
    gender: String? = null,
    mobileNum: String? = null,
    fcmToken: String? = null,
    fcmTokenUpdateAt: LocalDateTime? = null,
    disabled: Boolean = false,
    disabledReason: String? = null
) {
    val id: Long? = id

    val loginId: String? = loginId

    val password: String? = password

    val passwordUpdatedAt: LocalDateTime? = passwordUpdatedAt

    val userRoleType: UserRoleType = userRoleType

    val refreshToken: String? = refreshToken

    val temporarily: Boolean = temporarily

    val kakaoId: String? = kakaoId

    val lastSigninSocialService: String? = lastSigninSocialService

    val name: String? = name

    val birthday: String? = birthday

    val gender: String? = gender

    val mobileNum: String? = mobileNum

    val fcmToken: String? = fcmToken


    val disabled: Boolean = disabled
}