package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.RepresentativeEntity;
import com.example.travelagency_backend.entity.UserEntity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepresentativeDto {
    private long id;
    private String last_name;
    private String name;
    private String middle_name;
    private String description;

    public static RepresentativeDto toDto(RepresentativeEntity entity) {
        return RepresentativeDto
                .builder()
                .id(entity.getId())
                .last_name(entity.getLast_name())
                .name(entity.getName())
                .middle_name(entity.getMiddle_name())
                .description(entity.getDescription())
                .build();
    }
}
