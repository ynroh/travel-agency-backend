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
@Table(name = "routes")
public class RouteEntity {
    @Id
    @GeneratedValue
    private long id;

    @Size(min = 4, message = "{validation.name.size.too_short}")
    @Size(max = 250, message = "{validation.name.size.too_long}")
    private String title;

    @OneToMany
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Set<CountryEntity> country;

    @ManyToMany
    @JoinColumn(name = "route_points_id", referencedColumnName = "id")
    private Set<RoutePointEntity> routePoints;
}
