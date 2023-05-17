package com.knock.bmt.admin.aggregate.member.adapter.`in`.rest

import com.knock.bmt.admin.config.ConfigServerConfig
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/aa")
class CommonController(val configServerConfig: ConfigServerConfig) {
    @GetMapping("/index")
    fun hello(): String? {
        return configServerConfig.username
    }
}