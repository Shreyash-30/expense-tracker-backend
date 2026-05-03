package com.project.paytrack_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {


    private int status;
    private String error;
    private String errorCode;
    private String message;
    private String path;
    private String method;
    private LocalDateTime timestamp;


    public static ErrorResponse from(   com.project.paytrack_backend.exception.AppException ex,
                                        String path,
                                        String method){
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(ex.getStatus())
                .error(resolveStatus(ex.getStatus()))
                .errorCode(ex.getErrorCode())
                .message(ex.getMessage())
                .path(path)
                .method(method)
                .build();
    }

    private static String resolveStatus(int status) {
        return switch (status) {
            case 400 -> "Bad Request";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            default -> "Error";
        };
    }




}
