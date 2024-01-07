package com.example.travelagency_backend.exception;

public class CountryAlreadyExistsException extends Exception{
    public CountryAlreadyExistsException(String message) {
        super(message);
    }
}
