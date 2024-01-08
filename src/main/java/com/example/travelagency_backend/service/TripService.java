package com.example.travelagency_backend.service;

import com.example.travelagency_backend.dto.trip.CreateTripRequest;
import com.example.travelagency_backend.dto.trip.TripDto;
import com.example.travelagency_backend.entity.TripEntity;
import com.example.travelagency_backend.exception.*;
import com.example.travelagency_backend.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public TripDto getTrip(Long id) throws TripNotFoundException {
        Optional<TripEntity> tripOptional = tripRepository.findById(id);
        TripEntity tripEntity;

        if (tripOptional.isPresent())
            tripEntity = tripOptional.get();
        else
            throw new TripNotFoundException("Trip not found");

        return TripDto.toDto(tripEntity);
    }

    public String createTrip(CreateTripRequest request) {


        TripEntity entity = TripEntity
                .builder()
                .cost(request.getCost())
                .departureDate(request.getDepartureDate())
                .arrivalDate(request.getArrivalDate())
                .touristsCount(request.getTouristsCount())
                .penaltyAmount(request.getPenaltyAmount())
                .build();

        TripEntity finalEntity = tripRepository.save(entity);

        tripRepository.save(finalEntity);

        return "Trip was successfully created";
    }
}
