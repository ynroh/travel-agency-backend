package com.example.travelagency_backend.repository;

import com.example.travelagency_backend.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends JpaRepository<TourEntity, Long> {
    Optional<TourEntity> findById(Long id);

    List<TourEntity> findAll();
}
