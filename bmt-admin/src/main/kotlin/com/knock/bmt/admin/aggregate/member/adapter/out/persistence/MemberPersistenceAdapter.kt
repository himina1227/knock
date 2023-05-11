package com.knock.bmt.admin.aggregate.member.adapter.out.persistence

import com.knock.bmt.admin.aggregate.member.application.port.out.repository.LoadAccountPort
import com.knock.bmt.admin.aggregate.member.application.port.out.repository.SignUpPort
import com.knock.bmt.admin.aggregate.member.domain.Member
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Repository

@Repository
class MemberPersistenceAdapter(
    private val repository: MemberRepository,
    private val mapper: MemberMapper
) : SignUpPort,
    LoadAccountPort {
    override fun signUp(member: Member): Member {
        val memberEntity = mapper.toEntity(member)
        repository.save(memberEntity)
        return mapper.toDomain(memberEntity)
    }

    override fun loadAccountByEmail(email: String): Member {
        val memberEntity = repository.findByEmail(email).orElseThrow() { throw NotFoundException() }
        return mapper.toDomain(memberEntity)
    }
}