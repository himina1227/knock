package com.knock.bmt.app.aggregate.member.adapter.out.persistence

import com.knock.bmt.common.enums.UserRoleType
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "member")
class AccountEntity(
    id: Long
) {
    @Id
    val id: Long = id
}