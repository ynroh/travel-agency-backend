package com.example.travelagency_backend.dto.tour;

import com.example.travelagency_backend.dto.CountryDto;
import com.example.travelagency_backend.dto.RepresentativeDto;
import com.example.travelagency_backend.dto.RoutePointDto;
import com.example.travelagency_backend.entity.TourEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourDto {
    private long id;
    private String title;
    private Double stayDuration;
    private BigDecimal cost;
    private List<String> photosUrl;
    private RepresentativeDto representative;
    private CountryDto country;
    private List<RoutePointDto> routePoints;

    public static TourDto toDto(TourEntity entity){
        return TourDto
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .stayDuration(entity.getStay_duration())
                .cost(entity.getCost())
                .photosUrl(entity.getPhotos_url())
                .representative(RepresentativeDto
                        .builder()
                        .id(entity.getRepresentative().getId())
                        .name(entity.getRepresentative().getName())
                        .last_name(entity.getRepresentative().getLast_name())
                        .middle_name(entity.getRepresentative().getMiddle_name())
                        .description(entity.getRepresentative().getDescription())
                        .build()
                )
                .country(CountryDto
                        .builder()
                        .id(entity.getId())
                        .name(entity.getTitle())
                        .build())
                .routePoints(entity.getRoutePoints()
                        .stream()
                        .map(RoutePointDto::toDto)
                        .toList())
                .build();
    }
}
