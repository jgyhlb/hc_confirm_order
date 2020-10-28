package com.hclg.hc_confirm_order.controller;

import com.hclg.hc_confirm_order.common.CodeMsg;
import com.hclg.hc_confirm_order.common.Result;
import com.hclg.hc_confirm_order.pojo.EnterStudyRegister;
import com.hclg.hc_confirm_order.service.EnterStudyRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enteredInfo")
@CrossOrigin(origins = "*",allowCredentials = "true")
public class EnterStudyRegisterController {

    @Autowired
    private EnterStudyRegisterService enterStudyRegisterService;

        @PostMapping("/saveInfo")
        public Result saveName(EnterStudyRegister enterStudyRegister){
            Integer code = enterStudyRegisterService.saveInfo(enterStudyRegister);
            if (code!=0){
                return Result.error(CodeMsg.DATA_INSERT_ERROR,"学生信息插入失败");
            }
            return Result.success();
    }
}
