package com.knock.bmt.common.exception;

import com.knock.bmt.common.enums.ResponseCode;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

public class GlobalException extends RuntimeException {

    private String status;

    private Object data;

    public GlobalException() {
    }

    public GlobalException(String message) {
        super(message);
        this.status = "9999";
    }

    public GlobalException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.status = responseCode.getStatus();
    }

    public GlobalException(ResponseCode responseCode, Object data) {
        super(responseCode.getMessage());
        this.status = responseCode.getStatus();
        this.data = data;
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
        status = "9999";
    }

    public GlobalException(String message, ResponseCode responseCode) {
        super(message);
        this.status = responseCode.getStatus();
    }

    public GlobalException(Throwable cause) {
        super(cause);
        status = "9999";
    }
}
