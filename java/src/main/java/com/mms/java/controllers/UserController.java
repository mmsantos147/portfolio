package com.mms.java.controllers;

import com.mms.java.entity.User;
import com.mms.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping(path = "{userEmail}")
    public Optional<User> getUserByEmail(@PathVariable("userEmail") String email) {

        return userService.getUserByEmail(email);

    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "{userEmail}")
    public void deleteUser(@PathVariable("userEmail") String email) {
        userService.deleteUser(email);
    }
}
