package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.CountryEntity;
import com.example.travelagency_backend.entity.RouteEntity;
import com.example.travelagency_backend.entity.RoutePointEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {
    private long id;
    private String title;

    private static RouteDto toDto(RouteEntity entity){
        return RouteDto
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }
}
