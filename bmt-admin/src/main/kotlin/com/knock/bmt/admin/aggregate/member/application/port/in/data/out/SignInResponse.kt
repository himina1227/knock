package com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out

import com.knock.bmt.admin.aggregate.member.domain.Member

class SignInResponse(val email: String, val name: String) {
    companion object {
        fun of(member: Member): SignInResponse {
            return SignInResponse(
                email = member.email,
                name = member.name
            )
        }
    }
}