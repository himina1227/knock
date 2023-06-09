package com.knock.bmt.admin.aggregate.member.application.port.out.repository

interface LeavePort {
    fun leave(id: Long)
}