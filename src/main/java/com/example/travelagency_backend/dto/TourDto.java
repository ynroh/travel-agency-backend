package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.TourEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourDto {
    private long id;
    private String title;

    private static TourDto toDto(TourEntity entity){
        return TourDto
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }
}
