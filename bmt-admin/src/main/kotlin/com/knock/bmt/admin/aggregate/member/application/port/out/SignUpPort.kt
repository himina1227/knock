package com.knock.bmt.admin.aggregate.member.application.port.out

import com.knock.bmt.admin.aggregate.member.domain.Member

interface SignUpPort {
    fun signUp(member: Member) : Member
}