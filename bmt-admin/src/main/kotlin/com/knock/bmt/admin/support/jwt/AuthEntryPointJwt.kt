package com.knock.bmt.admin.support.jwt

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint

class AuthEntryPointJwt : AuthenticationEntryPoint {

    private val logger = KotlinLogging.logger { AuthEntryPointJwt() }

    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {

        logger.error("Unauthorized error: ${authException?.message}")

        response!!.contentType = MediaType.APPLICATION_JSON_VALUE
        response.status = HttpStatus.UNAUTHORIZED.value()
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
    }

}