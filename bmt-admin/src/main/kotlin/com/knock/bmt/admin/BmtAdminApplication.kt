package com.knock.bmt.admin

import com.knock.bmt.admin.property.ApiConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties
@SpringBootApplication
class MemberAdminApplication

fun main(args: Array<String>) {
    runApplication<MemberAdminApplication>(*args)
}
