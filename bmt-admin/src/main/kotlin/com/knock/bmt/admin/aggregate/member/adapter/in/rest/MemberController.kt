package com.knock.bmt.admin.aggregate.member.adapter.`in`.rest

import com.knock.bmt.admin.aggregate.member.application.port.`in`.SignInUseCase
import com.knock.bmt.admin.aggregate.member.application.port.`in`.SignUpUseCase
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignInRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignUpRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignInResponse
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignUpResponse
import com.knock.bmt.admin.support.PrincipalDetails
import com.knock.bmt.common.response.DefaultResponse
import org.hibernate.annotations.Parameter
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    val signUpUseCase: SignUpUseCase,
    val signInUseCase: SignInUseCase
) {
    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest): DefaultResponse<SignUpResponse> {
        return DefaultResponse.successWithData(signUpUseCase.signUp(request))
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody request: SignInRequest): DefaultResponse<SignInResponse> {
        return DefaultResponse.successWithData(signInUseCase.signIn(request))
    }

    @DeleteMapping("/leave")
    fun leave(@AuthenticationPrincipal principalDetails: PrincipalDetails): DefaultResponse<Void> {
        return DefaultResponse.success();
    }
}