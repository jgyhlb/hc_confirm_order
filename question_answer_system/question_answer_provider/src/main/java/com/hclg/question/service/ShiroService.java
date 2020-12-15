package com.hclg.question.service;

import com.hclg.question.pojo.SysToken;
import com.hclg.question.pojo.User;

import java.util.List;
import java.util.Map;

public interface ShiroService {
    User findByUsername(String username);
    Map<String, Object> createToken(Integer userId);
    void logout(String token);
    SysToken findByToken(String accessToken);
    User findByUserId(Integer userId);



    List<User> queryAllUsers();
    Integer insertOneUser(User user);
    Integer deleteOneUser(Integer userId);
    Integer updatePassword(User user);
}
