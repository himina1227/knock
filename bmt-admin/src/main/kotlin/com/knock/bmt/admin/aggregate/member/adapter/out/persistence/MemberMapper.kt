package com.knock.bmt.admin.aggregate.member.adapter.out.persistence

import com.knock.bmt.admin.aggregate.member.domain.Member
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class MemberMapper {
    fun toEntity(domain: Member, passwordEncoder: PasswordEncoder) = MemberEntity(
        domain.id,
        domain.email,
        domain.name,
        domain.userRoleType,
        domain.password.toEncode(passwordEncoder),
        domain.disabled
    )

    fun toDomain(entity: MemberEntity) = Member(
        entity.id,
        entity.email,
        entity.name,
        entity.userRoleType,
        entity.password,
        entity.disabled
    )
}