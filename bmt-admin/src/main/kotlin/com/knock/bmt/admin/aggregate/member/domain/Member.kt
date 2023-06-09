package com.knock.bmt.admin.aggregate.member.domain

import com.knock.bmt.common.enums.UserRoleType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class Member (
    id: Long?,
    email: String,
    name: String,
    userRoleType: UserRoleType,
    password: String,
    disabled: Boolean
) {
    val id: Long? = id // 아이디

    val email: String = email // 이메일

    val name: String = name // 이름

    val userRoleType: UserRoleType = userRoleType // 권한

    var password: String = password // 비밀번호

    var disabled: Boolean = disabled

}