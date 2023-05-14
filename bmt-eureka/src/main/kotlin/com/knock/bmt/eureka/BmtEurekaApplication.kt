package com.knock.bmt.eureka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class BmtEurekaApplication

fun main(args: Array<String>) {
    runApplication<BmtEurekaApplication>(*args)
}
