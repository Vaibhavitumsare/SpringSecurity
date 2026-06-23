package com.vaibhavi.Springsecurity.controller;

import com.vaibhavi.Springsecurity.model.Users;
import com.vaibhavi.Springsecurity.repo.UserRepo;
import com.vaibhavi.Springsecurity.service.MyUserDetailService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    MyUserDetailService myUserDetailService;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/users")
    public List<Users> getUsers()
    {
        return userRepo.findAll();
    }



    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Hello Vaibhavi"+request.getSession().getId();
    }


}




