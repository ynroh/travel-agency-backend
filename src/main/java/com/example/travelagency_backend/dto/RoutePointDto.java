package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.RoutePointEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoutePointDto {
    private long id;
    private String title;
    private Double stayDuration;
    private HotelDto hotels;
    private ExcursionDto excursions;
    private CityDto city;

    public static RoutePointDto toDto(RoutePointEntity entity){
        return RoutePointDto
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .stayDuration(entity.getStayDuration())
                .hotels(HotelDto
                        .builder()
                        .id(entity.getHotel().getId())
                        .title(entity.getHotel().getTitle())
                        .raiting(entity.getHotel().getRating())
                        .build())
                .excursions(ExcursionDto
                        .builder()
                        .id(entity.getExcursion().getId())
                        .title(entity.getExcursion().getTitle())
                        .description(entity.getExcursion().getDescription())
                        .build())
                .city(CityDto
                        .builder()
                        .id(entity.getCity().getId())
                        .name(entity.getCity().getName())
                        .build())
                .build();
    }
}
