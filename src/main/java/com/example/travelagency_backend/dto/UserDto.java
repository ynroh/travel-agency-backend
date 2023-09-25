package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.UserEntity;
import com.example.travelagency_backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String full_name;
    private Role role;
    private String password;

    public static UserDto toDto(UserEntity entity) {
        return UserDto
                .builder()
                .id(entity.getId())
                .full_name(entity.getFull_name())
                .role(entity.getRole())
                .build();
    }
}
