package com.hclg.question.service;


import com.github.pagehelper.PageInfo;
import com.hclg.question.common.Page;
import com.hclg.question.dto.DateDTO;
import com.hclg.question.pojo.QuestionAndAnswer;
import com.hclg.question.pojo.SysToken;

import java.util.List;

public interface QuestionAnswerService {
//    List<QuestionAndAnswer> queryAllQuestion();
//    PageInfo<QuestionAndAnswer> queryAllQuestion(Page page, SysToken sysToken);
//    PageInfo<QuestionAndAnswer> queryAnswerQuestionByEditorStatus(Page page,String editorStatus,SysToken sysToken);
//    PageInfo<QuestionAndAnswer> queryAllByQuestion(Page page,String question,SysToken sysToken);
    PageInfo<QuestionAndAnswer> queryAllQuestion(Page page, SysToken sysToken, QuestionAndAnswer questionAndAnswer, DateDTO dateDTO);
    List<QuestionAndAnswer> queryNoAnswerQuestion();
    QuestionAndAnswer queryQuestionById(Integer id);
    Integer deleteOneQuestionById(Integer id);
    Integer updateOneQuestion(QuestionAndAnswer questionAndAnswer);
    Integer insertOneQuestion(QuestionAndAnswer questionAndAnswer);
    Integer uploadOneQuestion(QuestionAndAnswer questionAndAnswer);
}
