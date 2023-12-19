package com.example.travelagency_backend.exception;

public class RefreshTokenNotFoundException extends Exception{
    public RefreshTokenNotFoundException(String message) {
        super(message);
    }
}
