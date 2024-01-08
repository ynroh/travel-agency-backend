package com.example.travelagency_backend.dto.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTripRequest {
    private BigDecimal cost;
    private Date departureDate;
    private Date arrivalDate;
    private int touristsCount;
    private BigDecimal penaltyAmount;
}
