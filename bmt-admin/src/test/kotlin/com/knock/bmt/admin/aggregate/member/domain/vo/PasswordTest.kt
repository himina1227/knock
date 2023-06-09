package com.knock.bmt.admin.aggregate.member.domain.vo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder

@DisplayName("Password 유닛 테스트")
class PasswordTest(@Autowired val passworedEncoder: PasswordEncoder) {

    @Test
    fun 비밀번호가_8자리에서_12자리_사이가_Exception_발생한다() {
        val password = Password(passworedEncoder, "111")
    }
}