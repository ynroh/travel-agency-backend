package com.example.travelagency_backend.service;

import com.example.travelagency_backend.dto.tour.CatalogTourDto;
import com.example.travelagency_backend.dto.tour.CreateTourRequest;
import com.example.travelagency_backend.dto.tour.TourDto;
import com.example.travelagency_backend.entity.CountryEntity;
import com.example.travelagency_backend.entity.RepresentativeEntity;
import com.example.travelagency_backend.entity.TourEntity;
import com.example.travelagency_backend.exception.*;
import com.example.travelagency_backend.repository.CountryRepository;
import com.example.travelagency_backend.repository.RepresentativeRepository;
import com.example.travelagency_backend.repository.RoutePointRepository;
import com.example.travelagency_backend.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    private TourRepository tourRepository;
    private RepresentativeRepository representativeRepository;
    private CountryRepository countryRepository;
    private RoutePointRepository routePointRespository;
    public TourDto getTour(Long id) throws TourNotFoundException {
        Optional<TourEntity> tourOptional = tourRepository.findById(id);
        TourEntity tourEntity;

        if (tourOptional.isPresent())
            tourEntity = tourOptional.get();
        else
            throw new TourNotFoundException("Tour not found");

        return TourDto.toDto(tourEntity);
    }

    public CatalogTourDto getCatalogTour(Long id) throws TourNotFoundException {
        Optional<TourEntity> tourOptional = tourRepository.findById(id);
        TourEntity tourEntity;

        if (tourOptional.isPresent())
            tourEntity = tourOptional.get();
        else
            throw new TourNotFoundException("Tour not found");

        return CatalogTourDto.toDto(tourEntity);
    }

    public String createTour(CreateTourRequest request) throws RepresentativeNotFoundException, CountryNotFoundException, TourPointNotFoundException {
        List<Long> routePointIds = request.getRoutePointIds();

        RepresentativeEntity representativeEntity = representativeRepository.findById(request.getRepresentativeId())
                .orElseThrow(() -> new RepresentativeNotFoundException("Representative not found"));

        CountryEntity countryEntity = countryRepository.findById(request.getCountryId())
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));

        TourEntity entity = TourEntity
                .builder()
                .title(request.getTitle())
                .stay_duration(request.getStayDuration())
                .cost(request.getCost())
                .photos_url(request.getPhotosUrl())
                .representative(representativeEntity)
                .country(countryEntity)
                .routePoints(new HashSet<>())
                .build();

        TourEntity finalEntity = tourRepository.save(entity);

        if (routePointIds != null) {
            addRoutePoints(finalEntity, routePointIds);
        }

        tourRepository.save(finalEntity);

        return "Tour was successfully created";
    }

    public String deleteTour(Long id) throws TourNotFoundException {
        Optional<TourEntity> tourOptional = tourRepository.findById(id);
        TourEntity tourEntity;

        if (tourOptional.isPresent())
            tourEntity = tourOptional.get();
        else
            throw new TourNotFoundException("Tour not found");

        tourRepository.delete(tourEntity);

        return "Tour was successfully deleted";
    }

    private void addRoutePoints(TourEntity entity, List<Long> routePointIds) throws TourPointNotFoundException {
        for(Long id : routePointIds) {
            entity.addRoutePoint(routePointRespository
                    .findById(id)
                    .orElseThrow(() -> new TourPointNotFoundException("Route point not found"))
            );
        }
    }
}
