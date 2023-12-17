package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.CityEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {
    private long id;
    private String title;

    private static CityDto toDto(CityEntity entity){
        return CityDto
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .build();
    }
}
