package com.spring.hotel.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@Setter
public class ApiPayload {
    private String message;
    private  boolean success;
    private HttpStatus status;
}
