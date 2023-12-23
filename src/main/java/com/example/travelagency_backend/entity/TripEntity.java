package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trips")
public class TripEntity {
    @Id
    @GeneratedValue
    private long id;

    private BigDecimal cost;

    private Date departureDate;

    private Date arrivalDate;

    private int touristsCount;

    private BigDecimal penaltyAmount;

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    private TourEntity tour;


    @OneToMany(mappedBy = "trip")
    private Set<PassportTripEntity> passportTrip;
}
