package com.example.travelagency_backend.exception;

public class TripNotFoundException extends Exception{
    public TripNotFoundException(String message) {
        super(message);
    }
}
