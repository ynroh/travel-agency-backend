package com.example.travelagency_backend.dto;

import com.example.travelagency_backend.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
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
    private String phone_number;
    private String email;
    private String login;
    private String photo_url;

    public static UserDto toDto(UserEntity entity) {
        return UserDto
                .builder()
                .id(entity.getId())
                .phone_number(entity.getPhone_number())
                .email(entity.getEmail())
                .login(entity.getLogin())
                .photo_url(entity.getPhoto_url())
                .build();
    }
}
