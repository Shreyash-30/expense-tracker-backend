package com.project.paytrack_backend.exception;

import lombok.Data;

@Data
public class AppException extends RuntimeException {

    private final String errorCode;
    private final int status;

    public AppException(String message, String errorCode, int status){
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

}
