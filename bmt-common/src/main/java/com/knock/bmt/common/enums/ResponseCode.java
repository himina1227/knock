package com.knock.bmt.common.enums;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS("0000", "성공");

    private final String status;

    private final String message;

    ResponseCode(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
