package com.knock.bmt.admin.aggregate.member.application.service

import com.knock.bmt.admin.aggregate.member.application.port.`in`.SignInUseCase
import com.knock.bmt.admin.aggregate.member.application.port.`in`.SignUpUseCase
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignInRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignUpRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignInResponse
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.out.SignUpResponse
import com.knock.bmt.admin.aggregate.member.application.port.out.repository.LoadAccountPort
import com.knock.bmt.admin.aggregate.member.application.port.out.repository.SignUpPort
import jakarta.transaction.Transactional
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Transactional
@Service
class AccountService(
    val signUpPort: SignUpPort,
    val loadAccountPort: LoadAccountPort
) : SignUpUseCase, SignInUseCase {

    override fun signUp(request: SignUpRequest): SignUpResponse {
        val member = signUpPort.signUp(request.toDomain())
        return SignUpResponse.of(member)
    }

    override fun signIn(request: SignInRequest): SignInResponse {
        val member = loadAccountPort.loadAccountByEmail(request.email);
        if (request.password != member.password) {
            throw NotFoundException();
        }
        return SignInResponse.of(member)
    }
}