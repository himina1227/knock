package com.knock.bmt.admin.support

import com.knock.bmt.common.enums.ResponseCode
import com.knock.bmt.common.exception.GlobalException
import com.knock.bmt.common.response.DefaultResponse
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException::class)
    fun handlerWhatAilsYouException(ex: GlobalException): DefaultResponse<Void> {
        return DefaultResponse(ex.status, ex.message, null)
    }

    /**
     * [Valid] 어노테이션으로 유효성 검증을 통과하지 못 하였을 경우 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException?): DefaultResponse<Void> {
        val responseCode: ResponseCode = ResponseCode.INVALID_PARAMETERS
        return DefaultResponse(responseCode)
    }

    /**
     * [Valid] 어노테이션으로 인자 유효성 검사에 실패하면 발생하는 예외
     * GET 요청에서 [RequestParam] 의 데이터를 바인딩하지 못하면 발생합니다.
     */
    @ExceptionHandler(BindException::class)
    fun handlerBindException(ex: BindException?): DefaultResponse<Void> {
        val responseCode: ResponseCode = ResponseCode.INVALID_PARAMETERS
        return DefaultResponse(responseCode)
    }

    @ExceptionHandler(Exception::class)
    protected fun handleException(ex: Exception?): DefaultResponse<Void> {
        val responseCode: ResponseCode = ResponseCode.INVALID_PARAMETERS
        return DefaultResponse(responseCode)
    }
}
