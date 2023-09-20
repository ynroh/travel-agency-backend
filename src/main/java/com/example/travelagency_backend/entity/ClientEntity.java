package com.example.travelagency_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clients")
public class ClientEntity {
    @Id
    @GeneratedValue
    private long id;

    private String photoUrl;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
