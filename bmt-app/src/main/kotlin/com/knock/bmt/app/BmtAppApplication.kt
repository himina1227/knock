package com.knock.bmt.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan(basePackages = ["com.knock.bmt.app.*"])
@SpringBootApplication
class BmtAppApplication

fun main(args: Array<String>) {
    runApplication<BmtAppApplication>(*args)
}
