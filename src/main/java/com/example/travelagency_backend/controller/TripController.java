package com.example.travelagency_backend.controller;

import com.example.travelagency_backend.dto.trip.CreateTripRequest;
import com.example.travelagency_backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping("/{id}")
    public ResponseEntity getTrip(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tripService.getTrip(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity createTrip(@RequestBody CreateTripRequest request) {
        try {
            return ResponseEntity.ok(tripService.createTrip(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
