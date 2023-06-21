package com.knock.bmt.app.aggregate.terms.adapter.`in`.rest

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@RequestMapping("/terms")
class TermsController {

    @GetMapping("/privacy-policy")
    fun getPrivacyPolicy(model: Model): String {
        return "privacy-policy"
    }
}