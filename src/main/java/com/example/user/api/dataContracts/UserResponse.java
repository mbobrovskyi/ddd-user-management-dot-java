package com.example.user.api.dataContracts;

import java.time.LocalDateTime;

public class UserResponse {
    public long id;
    public String email;
    public String firstName;
    public String lastName;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
