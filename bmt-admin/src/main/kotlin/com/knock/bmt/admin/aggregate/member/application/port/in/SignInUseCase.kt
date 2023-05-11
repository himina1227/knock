package com.knock.bmt.admin.aggregate.member.application.port.`in`

import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignInRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignInResponse

interface SignInUseCase {
    fun signIn(request: SignInRequest): SignInResponse
}