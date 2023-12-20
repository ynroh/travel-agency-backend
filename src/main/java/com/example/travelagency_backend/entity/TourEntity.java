package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tours")
public class TourEntity {
    @Id
    @GeneratedValue
    private long id;

    @Size(min = 4, message = "{validation.name.size.too_short}")
    @Size(max = 250, message = "{validation.name.size.too_long}")
    private String title;

    private Double stay_duration;

    @OneToMany
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Set<CountryEntity> country;

    @ManyToMany(mappedBy = "tours")
    private Set<RoutePointEntity> routePoint;

    @OneToMany(mappedBy = "tour")
    private Set<TripEntity> trip;

}
