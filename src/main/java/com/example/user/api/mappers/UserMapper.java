package com.example.user.api.mappers;

import com.example.user.api.dataContracts.UserResponse;
import com.example.user.domain.entities.User;

public class UserMapper {
    public static UserResponse userToResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.id = user.getId();
        userResponse.email = user.getEmail().getValue();
        userResponse.firstName = user.getFirstName().getValue();
        userResponse.lastName = user.getLastName().getValue();
        userResponse.createdAt = user.getCreatedAt();
        userResponse.updatedAt = user.getUpdatedAt();
        return userResponse;
    }
}
