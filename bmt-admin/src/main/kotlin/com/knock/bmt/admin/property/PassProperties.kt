//package com.knock.bmt.admin.property
//
//import org.springframework.boot.context.properties.ConfigurationProperties
//import org.springframework.boot.context.properties.ConfigurationPropertiesScan
//import org.springframework.boot.context.properties.bind.ConstructorBinding
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//@ConfigurationProperties("integration.pass")
//@ConfigurationPropertiesScan
//data class PassProperties(
//    val registration: Registration,
//    val provider: Provider
//) {
//    data class Registration(
//        val siteCode: String,
//        val sitePassword: String,
//        val gubun: String,
//        val reqSeq: String
//    )
//
//    data class Provider(
//        val authorizeUri: String,
//        val redirectSuccessUri: String,
//        val successUri: String,
//        val redirectFailUri: String,
//        val failUri: String,
//    )
//}
