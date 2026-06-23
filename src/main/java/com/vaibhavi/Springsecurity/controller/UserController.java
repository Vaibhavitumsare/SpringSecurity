package com.vaibhavi.Springsecurity.controller;

import com.vaibhavi.Springsecurity.model.Users;
import com.vaibhavi.Springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users Register(@RequestBody Users user) {
        return userService.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.verify(user);
    }

}
