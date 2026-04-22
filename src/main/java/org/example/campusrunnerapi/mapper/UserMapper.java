package org.example.campusrunnerapi.mapper;

import org.example.campusrunnerapi.entity.User;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user") // 必须有这个方法
    List<User> findAll();
}