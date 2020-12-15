package com.hclg.student.dao;


import com.hclg.student.pojo.QuestionAndAnswer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionAnswerDao {

    Integer insertOneQuestion(QuestionAndAnswer questionAndAnswer);
    String queryQuestion(String question);

}
