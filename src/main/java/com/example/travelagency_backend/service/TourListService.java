package com.example.travelagency_backend.service;

import com.example.travelagency_backend.dto.tour.CatalogTourDto;
import com.example.travelagency_backend.exception.TourNotFoundException;
import com.example.travelagency_backend.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourListService {
    @Autowired
    private TourRepository tourRepository;
    public List<CatalogTourDto> getCatalogTour() throws TourNotFoundException {
        List<CatalogTourDto> tours = tourRepository.findAll()
                .stream()
                .map(CatalogTourDto::toDto)
                .toList();

        if (tours.isEmpty()) {
            throw new TourNotFoundException("Tours not found");
        }

        return tours;
    }
}
