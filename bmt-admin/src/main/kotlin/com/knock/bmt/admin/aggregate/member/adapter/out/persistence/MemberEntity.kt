package com.knock.bmt.admin.aggregate.member.adapter.out.persistence

import com.knock.bmt.common.enums.UserRoleType
import jakarta.persistence.*

@Entity
@Table(name = "member")
class MemberEntity (
    id: Long?,
    email: String,
    name: String,
    userRoleType: UserRoleType,
    password: String,
    disabled: Boolean
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = id // 아이디

    val email: String = email // 이메일

    val name: String = name // 이름

    val userRoleType: UserRoleType = userRoleType // 권한

    var password: String = password // 비밀번호

    var disabled: Boolean = disabled
}