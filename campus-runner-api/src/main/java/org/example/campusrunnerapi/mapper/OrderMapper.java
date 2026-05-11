package org.example.campusrunnerapi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.campusrunnerapi.entity.Order;
import java.util.List;

public interface OrderMapper {

    // 插入订单
    @Insert("INSERT INTO orders(content, phone, address, money, user_id) " +
            "VALUES(#{content}, #{phone}, #{address}, #{money}, #{userId})")
    int insert(Order order);

    // ✅ 只查询当前 userId 的订单（真正正确）
    @Select("SELECT * FROM orders WHERE user_id = #{userId} ORDER BY id DESC")
    List<Order> selectByUserId(@Param("userId") Integer userId);
}