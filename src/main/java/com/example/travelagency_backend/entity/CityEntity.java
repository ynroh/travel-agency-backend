package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
public class CityEntity {
    @Id
    @GeneratedValue
    private long id;

    @Size()
    private String title;

    @ManyToOne
    @JoinTable(
            name = "cities_representatives",
            joinColumns = @JoinColumn(name="city_id"),
            inverseJoinColumns = @JoinColumn(name="representative_id")
    )
    private RepresentativeEntity representative;

    @ManyToOne()
    private CountryEntity country;

    @OneToMany(mappedBy = "city")
    private Set<RoutePointEntity> routePoint;

}
