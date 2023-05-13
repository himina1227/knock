package com.knock.bmt.admin.aggregate.member.adapter.out.persistence

import com.knock.bmt.admin.aggregate.member.domain.Member
import org.springframework.stereotype.Component

@Component
class MemberMapper {
    fun toEntity(domain: Member) = MemberEntity(
        domain.id,
        domain.email,
        domain.name,
        domain.userRoleType,
        domain.password
    )

    fun toDomain(entity: MemberEntity) = Member(
        entity.id,
        entity.email,
        entity.name,
        entity.userRoleType,
        entity.password
    )
}