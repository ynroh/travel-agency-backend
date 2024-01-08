package com.example.travelagency_backend.dto.tour;

import com.example.travelagency_backend.dto.CountryDto;
import com.example.travelagency_backend.dto.RepresentativeDto;
import com.example.travelagency_backend.dto.RoutePointDto;
import com.example.travelagency_backend.entity.TourEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogTourDto {
    private long id;
    private String title;
    private Double stayDuration;
    private BigDecimal cost;
    private List<String> photosUrl;
    private CountryDto country;
    private RepresentativeDto representative;
    private List<RoutePointDto> routePoints;

    public static CatalogTourDto toDto(TourEntity entity){
        return CatalogTourDto
                .builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .stayDuration(entity.getStay_duration())
                .cost(entity.getCost())
                .photosUrl(entity.getPhotos_url())
                .country(CountryDto
                        .builder()
                        .id(entity.getCountry().getId())
                        .name(entity.getCountry().getName())
                        .build())
                .representative(RepresentativeDto
                        .builder()
                        .id(entity.getRepresentative().getId())
                        .last_name(entity.getRepresentative().getLast_name())
                        .name(entity.getRepresentative().getName())
                        .middle_name(entity.getRepresentative().getMiddle_name())
                        .description(entity.getRepresentative().getDescription())
                        .build())
                .routePoints(entity.getRoutePoints()
                        .stream()
                        .map(RoutePointDto::toDto)
                        .toList())
                .build();
    }
}
