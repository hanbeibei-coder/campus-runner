package org.example.campusrunnerapi.controller;

import org.example.campusrunnerapi.entity.Order;
import org.example.campusrunnerapi.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping("/add")
    public Map<String, Object> addOrder(@RequestBody Order order) {
        orderMapper.insert(order);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "发布成功");
        return result;
    }

    @GetMapping("/list")
    public Map<String, Object> listOrders(@RequestParam Integer userId) {
        List<Order> list = orderMapper.selectByUserId(userId);
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", list);
        return result;
    }
}