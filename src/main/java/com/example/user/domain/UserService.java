package com.example.user.domain;

import com.example.user.common.domain.Page;
import com.example.user.domain.entities.User;
import com.example.user.domain.valueObjects.Email;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public User getById(long id) {
        return userRepository.getById(id);
    }

    public User getByEmail(Email email) {
        return userRepository.getByEmail(email);
    }

    public Page<User> getAll() {
        return userRepository.getAll();
    }
}
