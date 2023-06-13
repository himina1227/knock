package com.knock.bmt.admin.aggregate.member.domain.vo

import com.knock.bmt.admin.enums.PasswordCharacterData
import com.knock.bmt.common.enums.ResponseCode
import com.knock.bmt.common.exception.GlobalException
import jakarta.persistence.Embeddable
import org.passay.*
import org.springframework.security.crypto.password.PasswordEncoder


@Embeddable
open class Password {
    var password: String? = null

    protected constructor()
    constructor(password: String?) {
        if (validate(password)) {
            this.password = password
        }
    }

    fun toEncode(passwordEncoder: PasswordEncoder): Password {
        password = passwordEncoder.encode(password)
        return this
    }
    fun changePassword(rawPassword: String?) {
        password = rawPassword
    }

    private fun validate(rawPassword: String?): Boolean {
        val result = PasswordValidator(checkPasswordRule()).validate(PasswordData(rawPassword))
        if (!result.isValid) {
            if (result.details.size > 0) {
                val errorCode = result.details[0].errorCode
                throw GlobalException("비밀번호 형식에 맞지 않습니다. ($errorCode)", ResponseCode.INVALID_REQUEST)
            } else throw GlobalException("비밀번호 형식에 맞지 않습니다.", ResponseCode.INVALID_REQUEST)
        }
        return true
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

