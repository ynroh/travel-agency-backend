package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "representatives")
public class RepresentativeEntity {
    @Id
    @GeneratedValue
    private long id;

    @Size(min = 1, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String last_name;

    @Size(min = 1, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String name;

    @Size(min = 1, message = "{validation.name.size.too_short}")
    @Size(max = 30, message = "{validation.name.size.too_long}")
    private String middle_name;

    private String description;

    @ManyToOne
    private CityEntity city;

    @OneToMany(mappedBy = "representative")
    private Set<TourEntity> tour;
}
