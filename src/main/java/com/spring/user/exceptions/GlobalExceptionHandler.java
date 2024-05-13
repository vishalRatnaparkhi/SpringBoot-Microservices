package com.spring.user.exceptions;

import com.spring.user.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity <ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException)
    {
      ApiResponse response= ApiResponse.builder().message(resourceNotFoundException.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
