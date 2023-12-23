package com.example.user.domain;

import com.example.user.common.domain.Page;
import com.example.user.domain.entities.User;
import com.example.user.domain.valueObjects.Email;

public interface UserRepository {
    User getById(long id);
    User getByEmail(Email email);
    Page<User> getAll();
    User save(User user);
}
