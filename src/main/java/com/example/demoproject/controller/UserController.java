package com.example.demoproject.controller;

import com.example.demoproject.model.User;
import com.example.demoproject.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    User read(@PathVariable int id){
        return userService.read(id);
    }

    @PostMapping
    User create(@RequestBody User user){
        return userService.create(user);
    }
}
