package com.knock.bmt.app.aggregate.member.adapter.out.persistence

import com.knock.bmt.app.aggregate.member.application.port.out.repository.SignUpPort
import com.knock.bmt.app.aggregate.member.domain.Account
import org.springframework.stereotype.Repository

@Repository
class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository
) : SignUpPort {

    override fun signUp(account: Account) {
        TODO("Not yet implemented")
    }

    override fun duplicateByEmail(email: String): Boolean {
        TODO("Not yet implemented")
    }
}