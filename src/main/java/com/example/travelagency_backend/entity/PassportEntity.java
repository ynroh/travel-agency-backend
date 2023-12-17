package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passports")
public class PassportEntity {
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

    @Column(name = "series", length = 4)
    private String series;

    @Column(name = "number", length = 6)
    private String number;

    private Date issueDate;

    private String whoIssued;

    private Date birthDate;

    @ManyToOne
    @JoinTable(
            name = "passports_trips",
            joinColumns = @JoinColumn(name="passport_id"),
            inverseJoinColumns = {
                    @JoinColumn(name="trip_id"),
                    @JoinColumn(name="user_id")
            }
    )
    private TripEntity trip;

    @ManyToOne
    @JoinTable(
            name = "passports_trips",
            joinColumns = @JoinColumn(name = "passport_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "trip_id"),
                    @JoinColumn(name = "user_id")
            }
    )
    private UserEntity user;
}