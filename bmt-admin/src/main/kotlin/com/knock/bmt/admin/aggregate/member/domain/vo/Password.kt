package com.knock.bmt.admin.aggregate.member.domain.vo

import com.knock.bmt.admin.enums.PasswordCharacterData
import com.knock.bmt.common.enums.ResponseCode
import com.knock.bmt.common.exception.GlobalException
import jakarta.persistence.Embeddable
import org.passay.*
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.*


@Embeddable
open class Password {
    var password: String? = null

    protected constructor()
    constructor(passwordEncoder: PasswordEncoder, password: String?) {
        if (validate(password)) {
            this.password = passwordEncoder.encode(password)
        }
    }

    fun match(passwordEncoder: PasswordEncoder, rawPassword: String?): Boolean {
        return passwordEncoder
            .matches(rawPassword, password)
    }

    fun changePassword(passwordEncoder: PasswordEncoder, rawPassword: String?) {
        password = passwordEncoder.encode(rawPassword)
    }

    private fun validate(rawPassword: String?): Boolean {
        val result = PasswordValidator(checkPasswordRule()).validate(PasswordData(rawPassword))
        if (!result.isValid) {
            if (result.details.size > 0) {
                val errorCode = result.details[0].errorCode
                throw GlobalException("비밀번호 형식에 맞지 않습니다.<br />($errorCode)", ResponseCode.INVALID_REQUEST)
            } else throw GlobalException("비밀번호 형식에 맞지 않습니다.", ResponseCode.INVALID_REQUEST)
        }
        return false
    }

    private fun checkPasswordRule(): List<Rule> {
        return listOf<Rule>(
            WhitespaceRule(),
            LengthRule(8, 16),
            CharacterRule(PasswordCharacterData.Special, 1),
            CharacterRule(PasswordCharacterData.Digit, 1)
        )
    }
}

