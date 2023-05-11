package com.knock.bmt.admin.aggregate.member.domain

data class Member (
    val id: Long? = null,
    val email: String,
    val name: String,
    val password: String
)