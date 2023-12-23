package com.example.user.api.mappers;

import com.example.user.api.dataContracts.UserResponse;
import com.example.user.domain.entities.User;

public class UserMapper {
    public static UserResponse userToDto(User user) {
        UserResponse dto = new UserResponse();
        dto.id = user.getId();
        dto.email = user.getEmail().getValue();
        dto.firstName = user.getFirstName().getValue();
        dto.lastName = user.getLastName().getValue();
        dto.createdAt = user.getCreatedAt();
        dto.updatedAt = user.getUpdatedAt();
        return dto;
    }
}
