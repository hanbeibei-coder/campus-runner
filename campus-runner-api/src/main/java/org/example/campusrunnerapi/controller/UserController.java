package org.example.campusrunnerapi.controller;

import org.example.campusrunnerapi.entity.User;
import org.example.campusrunnerapi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 登录
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> res = new HashMap<>();
        User u = userMapper.login(user.getUsername(), user.getPassword());

        if (u != null) {
            res.put("code", 200);
            res.put("msg", "登录成功");
        } else {
            res.put("code", 500);
            res.put("msg", "账号或密码错误");
        }
        return res;
    }

    // 注册
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        if (user == null) return Map.of("code",500,"msg","参数错误");

        userMapper.register(user);

        return Map.of(
                "code",200,
                "msg","注册成功"
        );
    }
}