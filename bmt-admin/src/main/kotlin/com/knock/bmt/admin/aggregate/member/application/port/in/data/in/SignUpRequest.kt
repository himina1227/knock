package com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`

import com.knock.bmt.admin.aggregate.member.domain.Member
import com.knock.bmt.common.enums.UserRoleType

class SignUpRequest(
    val name: String,
    val email: String,
    val password: String
) {

    fun toDomain(): Member {
        return Member(
            id = null,
            name = name,
            email = email,
            password = password,
            userRoleType = UserRoleType.GUEST,
            disabled = false
        )
    }
}