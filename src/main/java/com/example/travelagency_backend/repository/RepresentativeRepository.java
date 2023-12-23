package com.example.travelagency_backend.repository;

import com.example.travelagency_backend.entity.RepresentativeEntity;
import com.example.travelagency_backend.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepresentativeRepository extends JpaRepository<RepresentativeEntity, Long> {
    Optional<RepresentativeEntity> findById(Long id);
    Optional<RepresentativeEntity> findByName(String name);
}
