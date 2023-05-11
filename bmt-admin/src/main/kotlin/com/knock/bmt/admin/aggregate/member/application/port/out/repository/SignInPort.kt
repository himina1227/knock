package com.knock.bmt.admin.aggregate.member.application.port.out.repository

import com.knock.bmt.admin.aggregate.member.domain.Member

interface SignInPort {
    fun signIn(email: String, password: String): Member
}