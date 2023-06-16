package com.knock.bmt.admin.aggregate.member.adapter.`in`.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignInRequest
import com.knock.bmt.admin.aggregate.member.application.port.`in`.data.`in`.SignUpRequest
import com.knock.bmt.common.exception.GlobalException
import jakarta.annotation.PostConstruct
import jakarta.servlet.ServletException
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@AutoConfigureMockMvc
@DirtiesContext
@SpringBootTest
class MemberControllerTest(@Autowired val mockMvc: MockMvc,
                           @Autowired val objectMapper: ObjectMapper) {

    @PostConstruct
    fun init() {
        signup(SignUpRequest("test", "test@test.com", "test12!@#$"))
    }

    @Test
    @Throws(Exception::class)
    fun signup_라우트는_사용자_정보가_저장되어_name과_email_을_리턴한다() {
        val req = SignUpRequest("test1", "test1@test.com", "1234!@#$!")
        mockMvc.perform(
            MockMvcRequestBuilders.post("/members/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req))
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.email").value("test1@test.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("test1"))
    }

    @Test()
    fun signup_라우트는_사용자_정보가_기존에_있다면_이메일_중복_에러가_발생한다() {
        val req = SignUpRequest("test2", "test@test.com", "test12!@#$")

        mockMvc.perform(
            MockMvcRequestBuilders.post("/members/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req))
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("이메일이 중복 되었습니다"))

//        assertThat( mockMvc.perform(
//            MockMvcRequestBuilders.post("/members/sign-up")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(req))
//        ).andReturn().resolvedException == GlobalException::class.java)
//
//
//        assertThatThrownBy {
//            mockMvc.perform(
//                MockMvcRequestBuilders.post("/members/sign-up")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(objectMapper.writeValueAsString(req))
//            )
//        }
//            .isExactlyInstanceOf(ServletException::class.java)
//        val result = mockMvc.perform(
//            MockMvcRequestBuilders.post("/members/sign-up")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(req))
//        ).andDo(MockMvcResultHandlers.print())
//
//            .andReturn()
//        assertThat(result.resolvedException == GlobalException::class.java)
//            .andExpect((result) -> assertTrue(result.getRes))
//        assertThatExceptionOfType(GlobalException::class.java)
//            .isThrownBy(()->{
//            mockMvc.perform(
//                MockMvcRequestBuilders.post("/members/sign-up")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(objectMapper.writeValueAsString(req))
//            )
//        })
//
//        }.hasCause(GlobalException::class.java)
//        assertThatThrownBy {
//            mockMvc.perform(
//                MockMvcRequestBuilders.post("/members/sign-up")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(objectMapper.writeValueAsString(req))
//            )
//        }.hasCause(GlobalException::class.java)
//        }.hasCause(GlobalException::class.java)
//        ).andExpect(MockMvcResultMatchers.status().isBadRequest())
//        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    @ExceptionHandler(value = [GlobalException::class])
    fun signin_라우트는_로그인_정보가_사용자_정보와_일치할_경우_200을_리턴한다() {
//        val signupReq = SignUpRequest("test1", "test1@test.com", "1234!@#$!")
//        signup(signupReq)
        val req = SignInRequest("test@test.com", "1234!@#$!")
        mockMvc.perform(
            MockMvcRequestBuilders.post("/members/sign-in")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req))
        ).andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.email").value("test@test.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").isNotEmpty())
    }
    private fun signup(req: SignUpRequest): ResultActions {
        return mockMvc.perform(
            MockMvcRequestBuilders.post("/members/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req))
        )
    }

//    private fun getApiResultExceptionClass(result: MvcResult):  {
//        return Objects.requireNonNull(result.resolvedException)
//    }
}