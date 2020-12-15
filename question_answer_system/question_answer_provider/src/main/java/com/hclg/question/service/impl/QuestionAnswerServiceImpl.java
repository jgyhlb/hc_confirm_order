package com.hclg.question.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hclg.question.common.Page;
import com.hclg.question.dao.QuestionAnswerDao;
import com.hclg.question.dto.DateDTO;
import com.hclg.question.pojo.QuestionAndAnswer;
import com.hclg.question.pojo.SysToken;
import com.hclg.question.service.QuestionAnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

    @Resource
    private QuestionAnswerDao questionAnswerDao;


//    @Override
//    @Transactional
//    public PageInfo<QuestionAndAnswer> queryAllQuestion(Page page,SysToken sysToken) {
////        QuestionAndAnswer questionAndAnswer = questionAnswerDao.queryAnswerQuestionByUserId(sysToken.getUserId());
//        PageHelper.startPage(page.getPageNum(),page.getPageSize());
//        List<QuestionAndAnswer> questionAndAnswerList = questionAnswerDao.queryAllQuestion();
//        for (QuestionAndAnswer questionAndAnswer : questionAndAnswerList) {
//            if (sysToken.getUserId().equals(questionAndAnswer.getUserId())) {
//                questionAndAnswer.setEditorStatus("2");
//            }
//        }
//        PageInfo<QuestionAndAnswer> answerPageInfo = new PageInfo<>(questionAndAnswerList);
//        return answerPageInfo;
//    }

    @Override
    @Transactional
    public PageInfo<QuestionAndAnswer> queryAllQuestion(Page page, SysToken sysToken, QuestionAndAnswer questionAndAnswer, DateDTO dateDTO) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());

        if ("2".equals(questionAndAnswer.getEditorStatus())){
            questionAndAnswer.setEditorStatus("1");
            List<QuestionAndAnswer> questionAndAnswerList2 = questionAnswerDao.queryAllQuestions(questionAndAnswer,dateDTO.getStartTime(),dateDTO.getEndTime());
            List<QuestionAndAnswer> QuestionAndAnswers = new ArrayList<>();
            for (QuestionAndAnswer qdA : questionAndAnswerList2) {
                if (sysToken.getUserId().equals(qdA.getUserId())) {
                    qdA.setEditorStatus("2");
                    QuestionAndAnswers.add(qdA);
                }
            }
            PageInfo<QuestionAndAnswer> answerPageInfo = new PageInfo<>(QuestionAndAnswers);
            return answerPageInfo;
        }else {
            List<QuestionAndAnswer> questionAndAnswerList1 = null;
//            if (dateDTO.getStartTime() != "" && dateDTO.getEndTime()!= "") {
//                System.out.println(dateDTO.getStartTime());
//                System.out.println(dateDTO.getEndTime());
                questionAndAnswerList1 = questionAnswerDao.queryAllQuestions(questionAndAnswer,dateDTO.getStartTime() , dateDTO.getEndTime());
//            }else {
//                questionAndAnswerList1 = questionAnswerDao.queryAllQuestions(questionAndAnswer, null, null);
//            }
            for (QuestionAndAnswer qdA : questionAndAnswerList1) {
                if (sysToken.getUserId().equals(qdA.getUserId())) {
                    qdA.setEditorStatus("2");
                }
            }
            PageInfo<QuestionAndAnswer> answerPageInfo = new PageInfo<>(questionAndAnswerList1);
            return answerPageInfo;
        }

//        PageInfo<QuestionAndAnswer> answerPageInfo = new PageInfo<>(questionAndAnswerList);
//        return null;
    }

//    @Override
//    public List<QuestionAndAnswer> queryAllQuestion() {
//        return questionAnswerDao.queryAllQuestion();
//    }

    @Override
    public List<QuestionAndAnswer> queryNoAnswerQuestion() {
        return questionAnswerDao.queryNoAnswerQuestion();
    }

    @Override
    public QuestionAndAnswer queryQuestionById(Integer id) {
        return questionAnswerDao.queryQuestionById(id);
    }

//    @Override
//    public PageInfo<QuestionAndAnswer> queryAnswerQuestionByEditorStatus(Page page,String editorStatus,SysToken sysToken) {
//        PageHelper.startPage(page.getPageNum(),page.getPageSize());
//        if ("2".equals(editorStatus)){
//            editorStatus = "1";
//            List<QuestionAndAnswer> questionAndAnswerList = questionAnswerDao.queryAnswerQuestionByEditorStatus(editorStatus);
//            List<QuestionAndAnswer> QuestionAndAnswers = new ArrayList<>();
//            for (QuestionAndAnswer questionAndAnswer : questionAndAnswerList) {
//                if (sysToken.getUserId().equals(questionAndAnswer.getUserId())) {
//                    questionAndAnswer.setEditorStatus("2");
//                    QuestionAndAnswers.add(questionAndAnswer);
//                }
//            }
//                PageInfo<QuestionAndAnswer> answerPageInfo = new PageInfo<>(QuestionAndAnswers);
//                return answerPageInfo;
//        }else {
//            List<QuestionAndAnswer> questionAndAnswerList = questionAnswerDao.queryAnswerQuestionByEditorStatus(editorStatus);
//            for (QuestionAndAnswer questionAndAnswer : questionAndAnswerList) {
//                if (sysToken.getUserId().equals(questionAndAnswer.getUserId())) {
//                    questionAndAnswer.setEditorStatus("2");
//                }
//            }
//            PageInfo<QuestionAndAnswer> answerPageInfo = new PageInfo<>(questionAndAnswerList);
//            return answerPageInfo;
//        }
//    }

//    @Override
//    @Transactional
//    public PageInfo<QuestionAndAnswer> queryAllByQuestion(Page page,String question,SysToken sysToken) {
//        PageHelper.startPage(page.getPageNum(),page.getPageSize());
//        List<QuestionAndAnswer> questionAndAnswerList = questionAnswerDao.queryAllByQuestion(question);
//        for (QuestionAndAnswer questionAndAnswer : questionAndAnswerList) {
//            if (sysToken.getUserId().equals(questionAndAnswer.getUserId())) {
//                questionAndAnswer.setEditorStatus("2");
//            }
//        }
//        PageInfo<QuestionAndAnswer> answerPageInfo = new PageInfo<>(questionAndAnswerList);
//        return answerPageInfo;
//    }

    @Override
    public Integer deleteOneQuestionById(Integer id) {
        return questionAnswerDao.deleteOneQuestionById(id);
    }

    @Override
    public Integer updateOneQuestion(QuestionAndAnswer questionAndAnswer) {
        return questionAnswerDao.updateOneQuestion(questionAndAnswer);
    }

    @Override
    public Integer insertOneQuestion(QuestionAndAnswer questionAndAnswer) {
        return questionAnswerDao.insertOneQuestion(questionAndAnswer);
    }

    @Override
    public Integer uploadOneQuestion(QuestionAndAnswer questionAndAnswer) {
        return questionAnswerDao.uploadOneQuestion(questionAndAnswer);
    }
}
