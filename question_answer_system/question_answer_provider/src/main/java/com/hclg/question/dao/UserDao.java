package com.hclg.question.dao;

import com.hclg.question.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    User findByUsername(@Param("username") String username);

    User findByUserId(@Param("userId") Integer userId);
    List<User> queryAllUsers();
    Integer insertOneUser(User user);
    Integer deleteOneUser(@Param("userId") Integer userId);
    Integer updatePassword(User user);
}
