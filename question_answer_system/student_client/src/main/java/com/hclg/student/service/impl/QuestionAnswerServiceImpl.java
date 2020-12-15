package com.hclg.student.service.impl;

import com.hclg.student.dao.QuestionAnswerDao;
import com.hclg.student.pojo.QuestionAndAnswer;
import com.hclg.student.service.QuestionAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    @Resource
    private QuestionAnswerDao questionAnswerDao;

    @Override
    public Integer insertOneQuestion(QuestionAndAnswer questionAndAnswer) {
        String question = questionAnswerDao.queryQuestion(questionAndAnswer.getQuestion());
        if (question != null) {
            return -1;
        }
        Integer insert = questionAnswerDao.insertOneQuestion(questionAndAnswer);
        return insert;
    }
}
