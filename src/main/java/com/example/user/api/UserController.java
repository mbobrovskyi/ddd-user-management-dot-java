package com.example.user.api;

import com.example.user.api.dataContracts.UserResponse;
import com.example.user.api.mappers.UserMapper;
import com.example.user.common.api.BaseController;
import com.example.user.common.domain.Page;
import com.example.user.domain.UserService;
import com.example.user.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/users")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Page<UserResponse> getUsers() {
        Page<User> page = userService.getAll();
        return new Page<>(
                page.getItems().stream().map(UserMapper::userToResponse).toList(),
                page.getCount());
    }

    @GetMapping( "{id}")
    public UserResponse getById(@PathVariable long id) {
        User user = userService.getById(id);
        return UserMapper.userToResponse(user);
    }
}
