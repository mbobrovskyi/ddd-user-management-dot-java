package com.example.user.domain;

import com.example.user.common.domain.Page;
import com.example.user.common.errors.NotFoundError;
import com.example.user.domain.entities.User;
import com.example.user.domain.valueObjects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getById(long id) {
        User user = userRepository.getById(id);
        if (user == null) {
            throw new NotFoundError();
        }

        return user;
    }

    public User getByEmail(Email email) {
        return userRepository.getByEmail(email);
    }

    public Page<User> getAll() {
        return userRepository.getAll();
    }
}
