package com.knock.bmt.app.aggregate.member.application.port.out.repository

import com.knock.bmt.app.aggregate.member.domain.Member

interface SignUpPort {
    fun signUp(member: Member) : Member

    fun duplicateByEmail(email: String): Boolean
}