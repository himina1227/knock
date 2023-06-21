package com.knock.bmt.app.aggregate.member.application.port.`in`.data

import com.knock.bmt.app.aggregate.member.domain.Account
import com.knock.bmt.app.enums.SocialServiceType
import com.knock.bmt.common.enums.ResponseCode
import com.knock.bmt.common.exception.GlobalException
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Null

data class SignUpRequest(
    @field:NotBlank(message = "socialServiceType은 필수 값 입니다.")
    val socialServiceType: SocialServiceType,
    @field:NotBlank(message = "id는 필수 값 입니다.")
    val id: String,
    @field:Null(message = "socialServiceType이 none인 경우 필수 값입니다.")
    val password: String
) {
    fun toDomain() = when (socialServiceType) {
        SocialServiceType.NONE -> Account(
            loginId = id
        )
        SocialServiceType.KAKAO_TALK -> Account(
            loginId = id
        )
        SocialServiceType.NAVER -> Account(
            loginId = id
        )
    }
}