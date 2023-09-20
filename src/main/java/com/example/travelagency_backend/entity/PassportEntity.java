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

    @Column(name = "series", length = 4)
    private String series;

    @Column(name = "number", length = 6)
    private String number;

    private Date issueDate;

    private String whoIssued;

    private Date birthDate;
}
