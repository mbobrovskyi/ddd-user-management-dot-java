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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Repository
public class UserRepositoryImpl extends BaseRepository implements UserRepository {
    @Override
    public User getById(long id) {
        List<User> found = users.stream().filter(u -> u.getId() == id).toList();
        if (found.size() == 0) {
            return null;
        }
        return found.get(0);
    }

    @Override
    public User getByEmail(Email email) {
        List<User> found = users.stream().filter(u -> u.getEmail().equals(email)).toList();
        if (found.size() == 0) {
            return null;
        }
        return found.get(0);
    }

    @Override
    public Page<User> getAll() {
        return new Page<>(users, users.size());
    }

    @Override
    public User save(User user) {
        users.add(
                new User(
                        lastId() + 1,
                        user.getEmail(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getCreatedAt(),
                        user.getUpdatedAt()));

        return user;
    }

    private static final User Alice = new User(
            1,
            new Email("alice@gmail.com"),
            new FirstName("Alice"),
            new LastName("Alison"),
            LocalDateTime.now(),
            LocalDateTime.now());

    private static final User Bob = new User(
            2,
            new Email("bob@gmail.com"),
            new FirstName("Bob"),
            new LastName("Bobson"),
            LocalDateTime.now(),
            LocalDateTime.now());

    private static List<User> initUsers() {
        List<User> users = new ArrayList<>();
        users.add(Alice);
        users.add(Bob);
        return users;
    }

    private static List<User> users = initUsers();

    private static long lastId() {
        return users.stream().max(Comparator.comparing(Entity::getId)).get().getId();
    };
}
