package com.knock.bmt.admin.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "api")
data class ApiConfiguration(
    var clientId: String = "",
    var url: String = "",
    var key: String = ""
)