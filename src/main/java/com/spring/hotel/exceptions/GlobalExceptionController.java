package com.spring.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiPayload> handlerResourceNotFoundException(ResourceNotFoundException re)
    {
        ApiPayload payload = ApiPayload.builder().message(re.getMessage()).status(HttpStatus.NOT_FOUND).success(false).build();
        return new ResponseEntity(payload,HttpStatus.NOT_FOUND);
    }
}
