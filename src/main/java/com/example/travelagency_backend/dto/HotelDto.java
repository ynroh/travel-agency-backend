package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private long id;
    private String title;
    private int raiting;

    private static HotelDto toDto(HotelEntity entity){
        return HotelDto
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .raiting(entity.getRating())
                .build();
    }
}
