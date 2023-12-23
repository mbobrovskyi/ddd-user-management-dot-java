package com.example.user.repositories;

import com.example.user.common.domain.Entity;
import com.example.user.common.domain.Page;
import com.example.user.common.repositories.BaseRepository;
import com.example.user.domain.entities.User;
import com.example.user.domain.UserRepository;
import com.example.user.domain.valueObjects.Email;
import com.example.user.domain.valueObjects.FirstName;
import com.example.user.domain.valueObjects.LastName;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Repository
public class UserRepositoryImpl extends BaseRepository implements UserRepository {
    @Override
    public User getById(long id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    @Override
    public User getByEmail(Email email) {
        return users.stream().filter(u -> u.getEmail().equals(email)).findFirst().get();
    }

    @Override
    public Page<User> getAll() {
        return new Page<>(users, users.size());
    }

    private static final User Alice = new User(
            1,
            Email.create("alice@gmail.com").getValue(),
            FirstName.create("Alice").getValue(),
            LastName.create("Alison").getValue(),
            LocalDateTime.now(),
            LocalDateTime.now());

    private static final User Bob = new User(
            2,
            Email.create("bob@gmail.com").getValue(),
            FirstName.create("Bob").getValue(),
            LastName.create("Bobson").getValue(),
            LocalDateTime.now(),
            LocalDateTime.now());

    private static final List<User> users = Arrays.asList(Alice, Bob);

    private static long lastId() {
        return users.stream().max(Comparator.comparing(Entity::getId)).get().getId();
    };
}
