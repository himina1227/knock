package com.knock.bmt.admin.aggregate.member.adapter.out.persistence

import com.knock.bmt.admin.aggregate.member.application.port.out.repository.LeavePort
import com.knock.bmt.admin.aggregate.member.application.port.out.repository.LoadAccountPort
import com.knock.bmt.admin.aggregate.member.application.port.out.repository.SignUpPort
import com.knock.bmt.admin.aggregate.member.domain.Member
import com.knock.bmt.common.enums.ResponseCode
import com.knock.bmt.common.exception.GlobalException
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class MemberPersistenceAdapter(
    private val repository: MemberRepository,
    private val mapper: MemberMapper,
    private val passwordEncoder: PasswordEncoder
) : SignUpPort,
    LoadAccountPort,
    LeavePort {

    override fun signUp(member: Member): Member {
        if (duplicateByEmail(member.email)) throw GlobalException(ResponseCode.DUPLICATED_EMAIL)
        val memberEntity = mapper.toEntity(member, passwordEncoder)
        repository.save(memberEntity)
        return mapper.toDomain(memberEntity)
    }

    override fun loadAccountByEmail(email: String): Member {
        val memberEntity = getEntityByEmail(email)
        return mapper.toDomain(memberEntity)
    }

    override fun leave(id: Long) {
        val memberEntity = getEntityById(id)
        memberEntity.disabled()
    }

    override fun duplicateByEmail(email: String): Boolean {
        return repository.existsByEmail(email)
    }

    fun getEntityByEmail(email: String): MemberEntity {
        return repository.findByEmail(email).orElseThrow() { throw NotFoundException() }
    }

    fun getEntityById(id: Long): MemberEntity {
        return repository.findById(id).orElseThrow() { throw NotFoundException() }
    }
}