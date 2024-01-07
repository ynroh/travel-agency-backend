package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private long id;
    private String name;

    public static CountryDto toDto(CountryEntity entity){
        return CountryDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
