package com.knock.bmt.admin.aggregate.tag.adapter.out.persistence

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class TagEntity (
    id: Long?,
    name: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = id // 아이디

    val name: String = name // 태그 네임
}