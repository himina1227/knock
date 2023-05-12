package com.knock.bmt.admin.aggregate.member.domain

import com.knock.bmt.common.enums.UserRoleType

data class Member (
    val id: Long? = null,
    val email: String,
    val name: String,
    val userRoleType: UserRoleType,
    val password: String
)