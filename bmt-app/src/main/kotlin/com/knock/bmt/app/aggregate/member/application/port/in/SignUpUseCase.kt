package com.knock.bmt.app.aggregate.member.application.port.`in`

import com.knock.bmt.app.aggregate.member.application.port.`in`.data.SignUpRequest

interface SignUpUseCase {
    fun signUp(request: SignUpRequest)
}