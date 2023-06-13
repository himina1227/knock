package com.knock.bmt.admin.aggregate.member.application.port.out.repository

import com.knock.bmt.admin.aggregate.member.domain.Member

interface SignUpPort {
    fun signUp(member: Member) : Member

    fun duplicateByEmail(email: String): Boolean
}