package org.example.campusrunnerapi.service;

import org.example.campusrunnerapi.entity.User;
import org.example.campusrunnerapi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    public int register(User user) {
        return userMapper.register(user);
    }

    public User findByUsername(String username) {
        return userMapper.findUserByName(username);
    }
}