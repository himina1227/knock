package com.knock.bmt.app.aggregate.member.application.port.`in`.data

import com.knock.bmt.app.aggregate.member.domain.Account
import com.knock.bmt.app.enums.SocialServiceType
import com.knock.bmt.common.enums.ResponseCode
import com.knock.bmt.common.exception.GlobalException
import jakarta.validation.constraints.NotBlank

data class SignUpRequest(
    @field:NotBlank(message = "socialServiceType은 필수 값 입니다.")
    val socialServiceType: SocialServiceType,
    @field:NotBlank(message = "socialId은 필수 값 입니다.")
    val socialId: String,
    @field:NotBlank(message = "passEncodeDataUlid은 필수 값 입니다.")
    val passEncodeDataUlid: String
) {
    fun toDomain() = when (socialServiceType) {
        SocialServiceType.KAKAO_TALK -> Account(
            kakaoId = socialId
        )
        SocialServiceType.NAVER -> Account(
            kakaoId = socialId
        )
    }
}