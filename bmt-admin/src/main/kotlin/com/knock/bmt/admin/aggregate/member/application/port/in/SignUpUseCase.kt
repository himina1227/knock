package com.knock.bmt.admin.aggregate.member.application.port.`in`

import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignUpRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignUpResponse

interface SignUpUseCase {
    fun signUp(request: SignUpRequest): SignUpResponse
}