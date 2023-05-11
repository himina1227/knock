package com.knock.bmt.admin.aggregate.member.adapter.`in`.rest

import com.knock.bmt.admin.aggregate.member.application.port.`in`.SignInUseCase
import com.knock.bmt.admin.aggregate.member.application.port.`in`.SignUpUseCase
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignInRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignUpRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignInResponse
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignUpResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    val signUpUseCase: SignUpUseCase,
    val signInUseCase: SignInUseCase
) {
    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest): SignUpResponse {
        return signUpUseCase.signUp(request);
    }

    @PostMapping("/sign-in")
    fun signIn(@RequestBody request: SignInRequest): SignInResponse {
        return signInUseCase.signIn(request);
    }
}