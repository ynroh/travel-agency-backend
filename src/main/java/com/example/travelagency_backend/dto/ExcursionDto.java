package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.ExcursionEntity;
import com.example.travelagency_backend.entity.HotelEntity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExcursionDto {
    private long id;
    private String title;
    private String description;

    private static ExcursionDto toDto(ExcursionEntity entity){
        return ExcursionDto
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }
}
