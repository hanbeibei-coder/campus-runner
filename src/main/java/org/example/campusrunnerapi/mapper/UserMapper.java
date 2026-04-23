package org.example.campusrunnerapi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.campusrunnerapi.entity.User;

public interface UserMapper {

    // 登录
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);

    // 注册
    @Insert("insert into user(username,password) values(#{username},#{password})")
    int register(User user);

    // 按用户名查询
    @Select("select * from user where username=#{username}")
    User findUserByName(@Param("username") String username);
}