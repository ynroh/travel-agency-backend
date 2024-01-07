package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "countries")
public class CountryEntity {
    @Id
    @GeneratedValue
    private long id;

    @Size()
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<CityEntity> cities;


    @OneToMany(mappedBy = "country")
    private Set<TourEntity> tour;
}
