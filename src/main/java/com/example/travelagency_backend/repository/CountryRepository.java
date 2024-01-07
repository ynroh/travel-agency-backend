package com.example.travelagency_backend.repository;

import com.example.travelagency_backend.entity.CountryEntity;
import com.example.travelagency_backend.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    Optional<CountryEntity> findById(Long id);

    Optional<CountryEntity> findByName(String name);
}
