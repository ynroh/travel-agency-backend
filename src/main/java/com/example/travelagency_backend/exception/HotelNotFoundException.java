package com.example.travelagency_backend.exception;

public class HotelNotFoundException extends Exception{
    public HotelNotFoundException(String message) {
        super(message);
    }
}
