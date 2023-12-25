package com.example.travelagency_backend.service;

import com.example.travelagency_backend.dto.tour.CatalogTourDto;
import com.example.travelagency_backend.exception.TourNotFoundException;
import com.example.travelagency_backend.repository.TourRepository;

import java.util.List;

public class TourListService {

    private TourRepository tourRepository;
    public List<CatalogTourDto> getCatalogTours() throws TourNotFoundException {
        List<CatalogTourDto> titles = tourRepository.findAll()
                .stream()
                .map(CatalogTourDto::toDto)
                .toList();

        if (titles.isEmpty()) {
            throw new TourNotFoundException("Tours not found");
        }

        return titles;
    }
}
