package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private DecimalFormat cost;

    private Date departureDate;

    private Date arrivalDate;

    private int touristsCount;

    private DecimalFormat penaltyAmount;

    @OneToMany
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Set<TourEntity> route;

    @OneToMany
    @JoinColumn(name = "representative_id", referencedColumnName = "id")
    private Set<RepresentativeEntity> representative;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private PassportEntity passport;


}
