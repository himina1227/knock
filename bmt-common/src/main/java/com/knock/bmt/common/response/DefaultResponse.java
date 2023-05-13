package com.knock.bmt.common.response;

import com.knock.bmt.common.enums.ResponseCode;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor
public class DefaultResponse<T> {

    private String status;

    private String message;

    private T data;

    @Builder
    public DefaultResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public DefaultResponse(ResponseCode responseCode, T data) {
        this.status = responseCode.getStatus();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    public DefaultResponse(ResponseCode responseCode) {
        this.status = responseCode.getStatus();
        this.message = responseCode.getMessage();
    }

    public DefaultResponse(ResponseCode responseCode, String message) {
        this.status = responseCode.getStatus();
        this.message = message;
    }

    public static <T> DefaultResponse<T> successWithData(T data) {
        return new DefaultResponse<>(ResponseCode.SUCCESS, data);

    }

    @Getter
    @NoArgsConstructor
    static class PagingModel<T> {
        private long totalElements;
        private int totalPages;
        private int pageNumber;
        private int size;
        private boolean first;
        private boolean last;

        public PagingModel(Page<T> page) {
            this.totalElements = page.getTotalElements();
            this.totalPages = page.getTotalPages();
            this.pageNumber = page.getNumber();
            this.size = page.getSize();
            this.first = page.isFirst();
            this.last = page.isLast();
        }

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PagedResponse<T> extends PagingModel<T> {
        private String status;
        private List<T> data;
        private String message;

        @Builder
        public PagedResponse(Page<T> page, String status, String message) {
            super(page);
            this.status = status;
            this.data = page.getContent();
            this.message = message;
        }

        @Builder
        public PagedResponse(Page<T> page, ResponseCode responseCode) {
            super(page);
            this.status = responseCode.getStatus();
            this.data = page.getContent();
            this.message = responseCode.getMessage();
        }

    }
}
