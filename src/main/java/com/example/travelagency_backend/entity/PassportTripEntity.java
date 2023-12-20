package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="passports_trips")
public class PassportTripEntity {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private PassportEntity passport;

    @ManyToOne
    private TripEntity trip;

    @ManyToOne
    private UserEntity user;
}
