package com.knock.bmt.app.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties("integration.pass", ignoreUnknownFields = false)
data class PassProperties @ConstructorBinding constructor(
    val registration: Registration,
    val provider: Provider
) {
    data class Provider(
        val authorizeUri: String,
        val redirectSuccessUri: String,
        val successUri: String,
        val redirectFailUri: String,
        val failUri: String)

    data class Registration(
        val siteCode: String,
        val sitePassword: String,
        val gubun: String,
        val reqSeq: String
    )
}
