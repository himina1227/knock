package com.knock.bmt.admin.aggregate.member.adapter.`in`.rest

import com.knock.bmt.admin.config.ConfigServerConfig
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class CommonController {
//    (val configServerConfig: ConfigServerConfig) {
//    @GetMapping("/index")
//    fun index(): String? {
//        return configServerConfig.username + "/" + configServerConfig.year
//    }

    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }
}
