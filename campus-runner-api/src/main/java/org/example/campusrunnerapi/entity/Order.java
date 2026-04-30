package org.example.campusrunnerapi.entity;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String content;
    private String phone;
    private String address;
    private Double money;
    private Integer userId;
}