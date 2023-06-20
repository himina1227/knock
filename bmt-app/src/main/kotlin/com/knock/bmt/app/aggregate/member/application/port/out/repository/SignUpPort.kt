package com.knock.bmt.app.aggregate.member.application.port.out.repository

import com.knock.bmt.app.aggregate.member.domain.Account

interface SignUpPort {
    fun signUp(account: Account)

    fun duplicateByEmail(email: String): Boolean
}