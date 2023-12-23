package com.example.travelagency_backend.repository;

import com.example.travelagency_backend.entity.RoutePointEntity;
import com.example.travelagency_backend.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoutePointRespository extends JpaRepository<RoutePointEntity, Long> {
    Optional<RoutePointEntity> findById(Long id);
    Optional<RoutePointEntity> findByName(String name);
}
