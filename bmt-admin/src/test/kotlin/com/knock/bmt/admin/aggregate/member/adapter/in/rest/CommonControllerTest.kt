package com.knock.bmt.admin.aggregate.member.adapter.`in`.rest

import com.knock.bmt.admin.config.ConfigServerConfig
import com.knock.bmt.admin.config.SecurityConfig
import com.knock.bmt.admin.support.UserDetailsServiceImpl
import com.knock.bmt.admin.support.jwt.JwtTokenProvider
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ContextConfiguration(classes = [
//    ConfigServerConfig::class,
    CommonController::class,
    SecurityConfig::class,
    JwtTokenProvider::class,
    UserDetailsServiceImpl::class])
@WebMvcTest(controllers = [CommonController::class])
class CommonControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun hello() {
        mockMvc.perform(get("/hello")
            .accept(MediaType.ALL))
            .andExpect(status().isOk())
            .andDo(MockMvcResultHandlers.print())
    }
}