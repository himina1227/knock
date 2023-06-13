package com.knock.bmt.admin.aggregate.member.domain.vo

import com.knock.bmt.common.exception.GlobalException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Password 유닛 테스트")
class PasswordTest {

    @Test
    fun 비밀번호가_8자리에서_12자리_사이가_아니면_TOO_SHORT_Exception_발생한다() {
        assertThatThrownBy {
            Password("11111234")
        }
            .isExactlyInstanceOf(GlobalException::class.java)
            .hasMessage("비밀번호 형식에 맞지 않습니다. (TOO_SHORT)")
    }

    @Test
    fun 비밀번호가_특수문자가_포함_안되면_INSUFFICIENT_SPECIAL_Exception이_발생한다() {
        assertThatThrownBy {
            Password("11111234")
        }
            .isExactlyInstanceOf(GlobalException::class.java)
            .hasMessage("비밀번호 형식에 맞지 않습니다. (INSUFFICIENT_SPECIAL)")
    }

    @Test
    fun 비밀번호가_숫자가_포함_안되면_INSUFFICIENT_DIGIT_Exception_발생한다() {
        assertThatThrownBy {
            Password("avasdvasd!")
        }
            .isExactlyInstanceOf(GlobalException::class.java)
            .hasMessage("비밀번호 형식에 맞지 않습니다. (INSUFFICIENT_DIGIT)")
    }
}