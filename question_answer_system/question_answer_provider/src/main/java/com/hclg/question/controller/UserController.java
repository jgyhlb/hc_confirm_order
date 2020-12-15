package com.hclg.question.controller;

import com.hclg.question.common.Result;
import com.hclg.question.pojo.User;
import com.hclg.question.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*",allowCredentials = "true")
public class UserController {

    @Autowired
    private ShiroService shiroService;



    @GetMapping("/user/queryAll")
    public Result<List> queryAllUsers() {
        List<User> users = shiroService.queryAllUsers();
        return new Result<>(200,"查询成功",users);
    }

    @PostMapping("/user/insertOne")
    public Result insertOneUser(@RequestBody User user) {
        Integer res = shiroService.insertOneUser(user);
        if (res >= 1) {
            return new Result<>(200,"新增成功",null);
        }else if (res == -1){
            return new Result<>(10001,"admin已存在",null);
        }else if (res == -2){
            return new Result<>(10001,"账号已存在",null);
        }
        return new Result<>(500,"新增失败");
    }

    @PostMapping("/user/deleteOne")
    public Result deleteOneUser(@RequestBody User user) {
        Integer res = shiroService.deleteOneUser(user.getUserId());
        if (res >= 1) {
            return new Result<>(200,"删除成功",null);
        }
        return new Result<>(999,"删除失败");
    }

    @PostMapping("/user/updateOne")
    public Result updatePassword(@RequestBody User user) {
        Integer res = shiroService.updatePassword(user);
        if (res >= 1) {
            return new Result<>(200,"更新成功",null);
        }
        return new Result<>(500,"更新失败");
    }
}
