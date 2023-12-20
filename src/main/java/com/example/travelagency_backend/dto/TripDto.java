package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.TripEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {
    private long id;
    private BigDecimal cost;
    private Date departureDate;
    private Date arrivalDate;
    private int touristsCount;
    private BigDecimal penaltyAmount;

    private static TripDto toDto(TripEntity entity) {
        return TripDto
                .builder()
                .id(entity.getId())
                .cost(entity.getCost())
                .departureDate(entity.getDepartureDate())
                .arrivalDate(entity.getArrivalDate())
                .touristsCount(entity.getTouristsCount())
                .penaltyAmount(entity.getPenaltyAmount())
                .build();
    }
}
