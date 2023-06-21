package com.knock.bmt.app.aggregate.member.application.port.`in`

interface PassUseCase {

    fun getAuthorizeUrl(): String

    fun getReqSeq(): String

}