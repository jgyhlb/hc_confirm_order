package com.hclg.question.dao;


import com.hclg.question.pojo.QuestionAndAnswer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface QuestionAnswerDao {
    List<QuestionAndAnswer> queryAllQuestions(@Param("questionAndAnswer") QuestionAndAnswer questionAndAnswer, @Param("startTime")Date startTime, @Param("endTime")Date endTime);
    QuestionAndAnswer queryQuestionById(@Param("id") Integer id);
    List<QuestionAndAnswer> queryNoAnswerQuestion();
    QuestionAndAnswer queryAnswerQuestionByUserId(Integer userId);
    Integer deleteOneQuestionById(@Param("id") Integer id);
    Integer updateOneQuestion(QuestionAndAnswer questionAndAnswer);
    Integer updateStatus(QuestionAndAnswer questionAndAnswer);
    Integer insertOneQuestion(QuestionAndAnswer questionAndAnswer);
    Integer uploadOneQuestion(QuestionAndAnswer questionAndAnswer);
}
