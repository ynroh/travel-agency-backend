package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
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

    private BigDecimal cost;

    @ElementCollection
    private List<String> photos_url;

    @ManyToOne
    @JoinColumn(name = "representative_id", referencedColumnName = "id")
    private RepresentativeEntity representative;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryEntity country;

    @ManyToMany(mappedBy = "tours")
    private Set<RoutePointEntity> routePoints;

    @OneToMany(mappedBy = "tour")
    private Set<TripEntity> trips;

    public TourEntity addRoutePoint(RoutePointEntity routePoint) {
        routePoints.add(routePoint);
        routePoint.getTours().add(this);
        return this;
    }

}
