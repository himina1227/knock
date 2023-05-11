package com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out

import com.knock.bmt.admin.aggregate.member.domain.Member

class SignUpResponse(
    val email: String,
    val name: String
) {
    companion object {
        fun of(member: Member): SignUpResponse {
            return SignUpResponse(
                email = member.email,
                name = member.name
            )
        }
    }
}