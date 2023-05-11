package com.knock.bmt.admin.aggregate.member.adapter.out.persistence

import jakarta.persistence.*

@Entity
@Table(name = "member")
class MemberEntity (
    id: Long?,
    email: String,
    name: String,
    password: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = id // 아이디

    @Column
    val email: String = email // 이메일

    @Column
    val name: String = name // 이름

    @Column
    var password: String = password // 비밀번호
}