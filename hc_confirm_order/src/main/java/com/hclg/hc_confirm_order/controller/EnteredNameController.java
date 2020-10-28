package com.hclg.hc_confirm_order.controller;


import com.hclg.hc_confirm_order.common.CodeMsg;
import com.hclg.hc_confirm_order.common.Result;
import com.hclg.hc_confirm_order.service.EnteredNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enteredname")
@CrossOrigin(origins = "*",allowCredentials = "true")
public class EnteredNameController {

    @Autowired
    private EnteredNameService enteredNameService;

    @GetMapping("/save")
    public Result saveName(@RequestParam String name){
        Integer code = enteredNameService.saveName(name);
        System.out.println("code = " + code);
        if (code!=0){
            return Result.error(CodeMsg.DATA_INSERT_ERROR,"学生姓名插入失败");
        }
        return Result.success();
    }
}
