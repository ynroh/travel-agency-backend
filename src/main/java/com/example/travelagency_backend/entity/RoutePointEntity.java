package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="route_points")
public class RoutePointEntity {
    @Id
    @GeneratedValue
    private long id;

    @Size(min = 4, message = "{validation.name.size.too_short}")
    @Size(max = 250, message = "{validation.name.size.too_long}")
    private String title;

    private Double stayDuration;

    private String tourName;

    @OneToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private HotelEntity hotel;
}
