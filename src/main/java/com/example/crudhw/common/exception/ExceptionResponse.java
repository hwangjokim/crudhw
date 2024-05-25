package com.example.crudhw.common.exception;

import com.example.crudhw.common.BaseResponse;

public class ExceptionResponse extends BaseResponse {
    private String message;

    public ExceptionResponse(Boolean success, String message) {
        super(success);
        this.message = message;
    }
}
