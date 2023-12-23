package com.example.travelagency_backend.dto.tour;

import com.example.travelagency_backend.dto.CountryDto;
import com.example.travelagency_backend.dto.RepresentativeDto;
import com.example.travelagency_backend.dto.RoutePointDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTourRequest {
    private String title;
    private Double stayDuration;
    private BigDecimal cost;
    private List<String> photosUrl;
    private Long representativeId;
    private Long countryId;
    private List<Long> routePointIds;
}
