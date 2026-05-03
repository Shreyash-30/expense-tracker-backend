package com.project.paytrack_backend.exception;

import com.project.paytrack_backend.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException ex, HttpServletRequest request) {
       ErrorResponse response = ErrorResponse.from(ex, request.getRequestURI(), request.getMethod());

       return ResponseEntity.status(response.getStatus()).body(response);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlValidation(MethodArgumentNotValidException ex,
                                                         HttpServletRequest request) {

      String message = ex.getBindingResult().getFieldErrors()
              .stream()
              .map(err-> err.getField() + ": " + err.getDefaultMessage())
              .findFirst()
              .orElse("Validation Error");


      ErrorResponse response = ErrorResponse.builder()
              .timestamp(LocalDateTime.now())
              .status(400)
              .error("Bad Request")
              .errorCode("VALIDATION_ERROR")
              .message(message)
              .path(request.getRequestURI())
              .method(request.getMethod())
              .build();

      return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {

        String path = request.getRequestURI();


        ErrorResponse response = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(500)
                .error("Internal Server Error")
                .errorCode("Internal_Error")
                .message(ex.getMessage())
                .path(path)
                .method(request.getMethod())
                .build();

        return ResponseEntity.internalServerError().body(response);

    }

}
