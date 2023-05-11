package com.knock.bmt.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BmtAppApplication

fun main(args: Array<String>) {
    runApplication<BmtAppApplication>(*args)
}
