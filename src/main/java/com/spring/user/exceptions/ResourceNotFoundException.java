package com.spring.user.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public  ResourceNotFoundException()
    {
        super("Resources not found on server !!");
    }
    public  ResourceNotFoundException(String message)
    {
        super(message);
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
