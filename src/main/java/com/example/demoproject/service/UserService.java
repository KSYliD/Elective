package com.example.demoproject.service;

import com.example.demoproject.model.User;

public interface UserService {
    User create(User user);
    User read(int id);
}
