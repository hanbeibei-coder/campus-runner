package org.example.campusrunnerapi.controller;

import org.example.campusrunnerapi.entity.User;
import org.example.campusrunnerapi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> res = new HashMap<>();
        User u = userService.login(user.getUsername(), user.getPassword());

        if (u != null) {
            res.put("code", 200);
            res.put("msg", "登录成功");
        } else {
            res.put("code", 500);
            res.put("msg", "账号或密码错误");
        }
        return res;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> res = new HashMap<>();
        User old = userService.findByUsername(user.getUsername());

        if (old != null) {
            res.put("code", 500);
            res.put("msg", "账号已存在");
            return res;
        }

        int rows = userService.register(user);
        if (rows > 0) {
            res.put("code", 200);
            res.put("msg", "注册成功");
        } else {
            res.put("code", 500);
            res.put("msg", "注册失败");
        }
        return res;
    }
}