package org.example.campusrunnerapi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.campusrunnerapi.entity.Order;
import java.util.List;

public interface OrderMapper {

    @Insert("INSERT INTO orders(content, phone, address, money, user_id) " +
            "VALUES(#{content}, #{phone}, #{address}, #{money}, #{userId})")
    int insert(Order order);

    @Select("SELECT * FROM orders WHERE user_id = #{userId} ORDER BY id DESC")
    List<Order> selectByUserId(Integer userId);
}