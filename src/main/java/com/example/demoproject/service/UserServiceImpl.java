package com.example.demoproject.service;

import com.example.demoproject.dao.UserDao;
import com.example.demoproject.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User read(int id) {
        return userDao.read(id);
    }
}
