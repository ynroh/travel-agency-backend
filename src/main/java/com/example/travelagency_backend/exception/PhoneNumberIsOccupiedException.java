package com.example.travelagency_backend.exception;

public class PhoneNumberIsOccupiedException extends Exception{
    public PhoneNumberIsOccupiedException(String message) {
        super(message);
    }
}