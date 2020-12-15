package com.hclg.upload.controller;


import com.hclg.upload.common.Result;
import com.hclg.upload.pojo.QuestionAndAnswer;
import com.hclg.upload.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true")
public class QuestionAnswerController{

    @Autowired
    private QuestionAnswerService questionAnswerService;


    @GetMapping("/question/getAll")
    public Result<List> queryAllQuestion() {
        List<QuestionAndAnswer> questionAndAnswers = questionAnswerService.queryAllQuestion();
        if (questionAndAnswers != null) {
            return new Result<>(200,"查询成功",questionAndAnswers);
        }
        return new Result<>(500,"查询失败");
    }

    @GetMapping("/question/getOne")
    public Result<QuestionAndAnswer> queryQuestionById(@RequestParam Integer id) {
        QuestionAndAnswer questionAndAnswer = questionAnswerService.queryQuestionById(id);
        if (questionAndAnswer != null) {
            return new Result<>(200,"查询成功",questionAndAnswer);
        }
        return new Result<>(500,"查询失败 id="+id);
    }

    @PostMapping("/question/deleteOne")
    public Result deleteOneQuestionById(@RequestBody QuestionAndAnswer questionAndAnswer) {
        Integer res = questionAnswerService.deleteOneQuestionById(questionAndAnswer.getId());
        if (res >= 1) {
            return new Result<>(200,"删除成功",null);
        }
        return new Result<>(500,"删除失败");
    }

    @PostMapping("/question/updateOne")
    public Result updateOneQuestion(@RequestBody QuestionAndAnswer questionAndAnswer) {
        questionAndAnswer.setCreateTime(new Date());
        Integer res = questionAnswerService.updateOneQuestion(questionAndAnswer);
        if (res >= 1) {
            return new Result<>(200,"更新成功",null);
        }
        return new Result<>(500,"更新失败");
    }

    @PostMapping("/question/insertOne")
    public Result insertOneQuestion(@RequestBody QuestionAndAnswer questionAndAnswer) {
        questionAndAnswer.setCreateTime(new Date());
        Integer res = questionAnswerService.insertOneQuestion(questionAndAnswer);
        if (res >= 1) {
            return new Result<>(200,"新增成功",null);
        }
        return new Result<>(500,"新增失败");
    }
}
