package com.example.travelagency_backend.exception;

public class EmailIsOccupiedException extends Exception{
    public EmailIsOccupiedException(String message) {
        super(message);
    }
}
