package com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`

import com.knock.bmt.admin.aggregate.member.domain.Member

class SignUpRequest(
    val name: String,
    val email: String,
    val password: String
) {

    fun toDomain(): Member {
        return Member(
            name = name,
            email = email,
            password = password
        )
    }
}