package com.knock.bmt.app.aggregate.member.application.service

import com.knock.bmt.app.aggregate.member.application.port.`in`.SignUpUseCase
import com.knock.bmt.app.aggregate.member.application.port.`in`.data.SignUpRequest
import com.knock.bmt.app.aggregate.member.application.port.out.repository.SignUpPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class AccountService(
    private val signUpPort: SignUpPort
) : SignUpUseCase {

    override fun signUp(request: SignUpRequest) {
        signUpPort.signUp(request.toDomain())
    }
}