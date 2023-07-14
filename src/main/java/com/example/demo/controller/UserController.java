package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserByUuid(@PathVariable Long id) {

        return userRepository.findUserById(id);
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public String saveUser(){

        return "New user created with ID: ";
    }
}
