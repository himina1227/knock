package com.knock.bmt.common.enums;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS("0000", "성공"),
    INVALID_REQUEST("0001", "잘못된 요청입니다.");

    private final String status;

    private final String message;

    ResponseCode(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
