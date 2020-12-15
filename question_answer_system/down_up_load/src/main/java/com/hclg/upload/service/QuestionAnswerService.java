package com.hclg.upload.service;


import com.hclg.upload.pojo.QuestionAndAnswer;

import java.util.List;

public interface QuestionAnswerService {
    List<QuestionAndAnswer> queryAllQuestion();
    QuestionAndAnswer queryQuestionById(Integer id);
    Integer deleteOneQuestionById(Integer id);
    Integer updateOneQuestion(QuestionAndAnswer questionAndAnswer);
    Integer insertOneQuestion(QuestionAndAnswer questionAndAnswer);
}
