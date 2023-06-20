package com.knock.bmt.app.aggregate.member.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<AccountEntity, Long> {
}