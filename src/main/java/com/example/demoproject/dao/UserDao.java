package com.example.demoproject.dao;

import com.example.demoproject.model.User;

public interface UserDao {
    User create(User user);
    User read(int id);
    void update(User user);
    void delete(User user);
}

