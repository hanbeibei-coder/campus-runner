package org.example.campusrunnerapi.service;

import org.example.campusrunnerapi.entity.User;
import org.example.campusrunnerapi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.findAll();
    }
}