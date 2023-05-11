package com.knock.bmt.admin.aggregate.member.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberRepository : JpaRepository<MemberEntity, Long> {
    fun findByEmail(email: String): Optional<MemberEntity>
}