package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.PassportEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassportDto {
    private long id;
    private String last_name;
    private String name;
    private String middle_name;
    private String series;
    private String number;
    private Date issueDate;
    private String whoIssued;
    private Date birthDate;

    private static PassportDto toDto(PassportEntity entity){
        return PassportDto
                .builder()
                .id(entity.getId())
                .last_name(entity.getLast_name())
                .name(entity.getName())
                .middle_name(entity.getMiddle_name())
                .series(entity.getSeries())
                .number(entity.getNumber())
                .issueDate(entity.getIssueDate())
                .whoIssued(entity.getWhoIssued())
                .birthDate(entity.getBirthDate())
                .build();

    }
}
