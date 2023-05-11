package com.knock.bmt.admin.aggregate.member.application.port.out.repository

import com.knock.bmt.admin.aggregate.member.domain.Member

interface LoadAccountPort {
    fun loadAccountByEmail(email: String): Member

}