package com.hclg.student.controller;


import com.hclg.student.common.Result;
import com.hclg.student.pojo.EnterStudyRegister;
import com.hclg.student.pojo.QuestionAndAnswer;
import com.hclg.student.service.QuestionAnswerService;
import com.hclg.student.service.StudentLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true")
@Slf4j
public class StudentLoginController {

    @Autowired
    private StudentLoginService studentLoginService;

    @Autowired
    private QuestionAnswerService questionAnswerService;



    @GetMapping("/login/{name}")
    public Result login(@PathVariable String name){

        EnterStudyRegister enterStudyRegister = studentLoginService.queryEnterStudyRegisterByName(name);
        if (enterStudyRegister == null) {
            return new Result(99999,"未报名课程",enterStudyRegister);
        }
        return new Result(200,"登陆成功",enterStudyRegister);
    }
    /**
     *
     * @param questionAndAnswer
     * @return
     * @throws ParseException
     */
    @PostMapping("/question/insertFromStudent")
    public Result insertOneFromStudent(@RequestBody QuestionAndAnswer questionAndAnswer) throws ParseException {
        questionAndAnswer.setCreateTime(new Date());
        questionAndAnswer.setEditorStatus("0");
        Integer res = questionAnswerService.insertOneQuestion(questionAndAnswer);
        if (res >= 1) {
            return new Result<>(200, "新增成功", null);
        }else if (res == -1){
            return new Result<>(10001,"问题已存在");
        }
        return new Result<>(500,"新增失败");
    }

}
