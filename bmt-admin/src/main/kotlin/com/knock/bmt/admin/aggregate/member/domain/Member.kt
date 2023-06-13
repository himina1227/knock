package com.knock.bmt.admin.aggregate.member.domain

import com.knock.bmt.admin.aggregate.member.domain.vo.Password
import com.knock.bmt.common.enums.UserRoleType

class Member(
    id: Long? = null,
    email: String,
    name: String,
    userRoleType: UserRoleType = UserRoleType.ADMIN,
    password: Password,
    disabled: Boolean = false
) {
    val id: Long? = id // 아이디

    val email: String = email // 이메일

    val name: String = name // 이름

    val userRoleType: UserRoleType = userRoleType // 권한

    val password: Password = password // 비밀번호

    var disabled: Boolean = disabled
}