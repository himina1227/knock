package com.knock.bmt.admin.aggregate.member.application.service

import com.knock.bmt.admin.aggregate.member.application.port.`in`.LeaveUseCase
import com.knock.bmt.admin.aggregate.member.application.port.`in`.SignInUseCase
import com.knock.bmt.admin.aggregate.member.application.port.`in`.SignUpUseCase
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignInRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignUpRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignInResponse
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignUpResponse
import com.knock.bmt.admin.aggregate.member.application.port.out.repository.LeavePort
import com.knock.bmt.admin.aggregate.member.application.port.out.repository.LoadAccountPort
import com.knock.bmt.admin.aggregate.member.application.port.out.repository.SignUpPort
import com.knock.bmt.admin.aggregate.member.domain.vo.Password
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Transactional
@Service
class AccountService(
    private val signUpPort: SignUpPort,
    private val loadAccountPort: LoadAccountPort,
    private val leavePort: LeavePort,
    private val passwordEncoder: PasswordEncoder
) : SignUpUseCase, SignInUseCase, LeaveUseCase {

    override fun signUp(request: SignUpRequest): SignUpResponse {
        val member = signUpPort.signUp(request.toDomain())
        return SignUpResponse.of(member)
    }

    override fun signIn(request: SignInRequest): SignInResponse {
        val member = loadAccountPort.loadAccountByEmail(request.email)
        return SignInResponse.of(member)
    }

    override fun leave(id: Long) {
        leavePort.leave(id)
    }
}