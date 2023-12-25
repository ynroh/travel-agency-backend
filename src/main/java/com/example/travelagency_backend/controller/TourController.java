package com.example.travelagency_backend.controller;

import com.example.travelagency_backend.dto.tour.CreateTourRequest;
import com.example.travelagency_backend.exception.TourNotFoundException;
import com.example.travelagency_backend.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tour")
public class TourController {
    private TourService tourService;


    @GetMapping("/{id}")
    public ResponseEntity getTour(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tourService.getTour(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/tour/{id}")
    public ResponseEntity getCatalogTour(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tourService.getCatalogTour(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity createTour(@RequestBody CreateTourRequest request) {
        try {
            return ResponseEntity.ok(tourService.createTour(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity deleteTour(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tourService.deleteTour(id));
        } catch (TourNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
