package com.knock.bmt.common.enums;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS("0000", "성공");

    private String status;

    private String message;

    ResponseCode(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
