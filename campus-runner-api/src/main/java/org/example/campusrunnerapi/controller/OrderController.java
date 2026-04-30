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

    // 发布订单接口（POST）
    @PostMapping("/add")
    public Map<String, Object> addOrder(@RequestBody Order order) {
        // 默认写死user_id=1，后续可改为登录用户ID
        order.setUserId(1);
        orderMapper.insert(order);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "发布成功");
        return result;
    }

    // 获取订单列表接口（GET）
    @GetMapping("/list")
    public Map<String, Object> listOrders() {
        List<Order> list = orderMapper.selectAll();

        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("data", list);
        return result;
    }
}