package com.knock.bmt.common.enums;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS("0000", "성공"),
    DUPLICATED_EMAIL("0002", "이메일이 중복 되었습니다"),
    INVALID_PARAMETERS("0003", "잘못된 인자값입니다"),
    INVALID_ENUM_PARAMETER("0004", "잘못된 Enum Type 입니다"),
    INVALID_REQUEST("0001", "잘못된 요청입니다.");

    private final String status;

    private final String message;

    ResponseCode(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
