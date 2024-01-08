package com.example.travelagency_backend.repository;

import com.example.travelagency_backend.entity.TourEntity;
import com.example.travelagency_backend.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TripRepository extends JpaRepository<TripEntity, Long> {
    Optional<TripEntity> findById(Long id);

    List<TripEntity> findAll();
}
