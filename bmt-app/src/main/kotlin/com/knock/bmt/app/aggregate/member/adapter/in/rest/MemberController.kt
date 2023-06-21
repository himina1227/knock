package com.knock.bmt.app.aggregate.member.adapter.`in`.rest

import com.knock.bmt.app.aggregate.member.application.port.`in`.SignUpUseCase
import com.knock.bmt.app.aggregate.member.application.port.`in`.data.SignUpRequest
import com.knock.bmt.common.response.DefaultResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/members")
class MemberController(
    val signUpUseCase: SignUpUseCase
) {
    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest): DefaultResponse<Void> {
        return DefaultResponse.success()
    }
}