package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.HotelEntity;
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
    private String tourName;
    private HotelEntity hotel;

    private static RoutePointDto toDto(RoutePointEntity entity){
        return RoutePointDto
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .stayDuration(entity.getStayDuration())
                .tourName(entity.getTourName())
                .hotel(entity.getHotel())
                .build();
    }
}
