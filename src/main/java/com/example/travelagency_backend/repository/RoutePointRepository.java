package com.example.travelagency_backend.repository;

import com.example.travelagency_backend.entity.RoutePointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoutePointRepository extends JpaRepository<RoutePointEntity, Long> {
    Optional<RoutePointEntity> findById(Long id);
}
