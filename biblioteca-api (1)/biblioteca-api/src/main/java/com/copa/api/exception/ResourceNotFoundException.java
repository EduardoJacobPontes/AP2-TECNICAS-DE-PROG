package com.copa.api.exception;

// Cumpre SOLID (Single Responsibility) e Clean Code: Isola erros de negócio
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}