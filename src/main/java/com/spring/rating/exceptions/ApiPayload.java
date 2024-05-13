package com.spring.rating.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiPayload {
    private  boolean success;
    private  String message;
    private HttpStatus status;
}
