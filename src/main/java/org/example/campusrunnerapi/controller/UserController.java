package org.example.campusrunnerapi.controller;

import org.example.campusrunnerapi.entity.User;
import org.example.campusrunnerapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/user") // 类上的路径前缀
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all") // 方法上的路径
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}