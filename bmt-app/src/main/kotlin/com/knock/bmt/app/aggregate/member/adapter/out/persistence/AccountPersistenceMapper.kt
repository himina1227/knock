package com.knock.bmt.app.aggregate.member.adapter.out.persistence

import com.knock.bmt.app.aggregate.member.domain.Account

class AccountPersistenceMapper {
    fun mapToEntity(domain: Account) = AccountEntity(
        id = domain.id,
        loginId = domain.loginId,
        password = domain.password,
        userRoleType = domain.userRoleType,
        refreshToken = domain.refreshToken,
        kakaoId = domain.kakaoId,
        name = domain.name,
    )

    fun mapToDomain(entity: AccountEntity): Account {
        return Account(
            id = entity.id,
            loginId = entity.loginId,
            password = entity.password,
            userRoleType = entity.userRoleType,
            refreshToken = entity.refreshToken,
            kakaoId = entity.kakaoId,
            name = entity.name,
        )
    }
}