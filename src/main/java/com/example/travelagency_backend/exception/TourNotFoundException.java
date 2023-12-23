package com.example.travelagency_backend.exception;

public class TourNotFoundException extends Exception{
    public TourNotFoundException(String message) {
        super(message);
    }
}
