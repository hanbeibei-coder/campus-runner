package org.example.campusrunnerapi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.example.campusrunnerapi.entity.User;

public interface UserMapper {

    @Insert("INSERT INTO user(username,password) VALUES(#{username},#{password})")
    int register(User user);

    @Select("SELECT * FROM user WHERE username=#{username} AND password=#{password}")
    User login(String username, String password);
}