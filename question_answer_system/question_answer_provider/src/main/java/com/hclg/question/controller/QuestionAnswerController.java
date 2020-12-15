package com.hclg.question.controller;

import com.github.pagehelper.PageInfo;
import com.hclg.question.common.Page;
import com.hclg.question.common.Result;
import com.hclg.question.dto.DateDTO;
import com.hclg.question.pojo.QuestionAndAnswer;
import com.hclg.question.pojo.SysToken;
import com.hclg.question.service.QuestionAnswerService;
import com.hclg.question.service.ShiroService;
import com.hclg.question.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true")
@Slf4j
public class QuestionAnswerController{

    @Autowired
    private QuestionAnswerService questionAnswerService;
    @Autowired
    private ShiroService shiroService;


//    @GetMapping("/question/getAll")
//    public Result<PageInfo> queryAllQuestion(Page page,HttpServletRequest httpServletRequest) {
//        String token = TokenUtil.getRequestToken(httpServletRequest);
//        SysToken sysToken = shiroService.findByToken(token);
//        PageInfo<QuestionAndAnswer> questionAndAnswers = questionAnswerService.queryAllQuestion(page,sysToken);
//        if (questionAndAnswers != null) {
//            return new Result<>(200,"查询成功",questionAndAnswers);
//        }
//        return new Result<>(500,"查询失败");
//    }
//
//    @GetMapping("/question/getSearchAll")
//    public Result<PageInfo> queryAllByQuestion(Page page,String question,HttpServletRequest httpServletRequest) {
//        String token = TokenUtil.getRequestToken(httpServletRequest);
//        SysToken sysToken = shiroService.findByToken(token);
//        PageInfo<QuestionAndAnswer> questionAndAnswers = questionAnswerService.queryAllByQuestion(page,question,sysToken);
//        if (questionAndAnswers != null) {
//            return new Result<>(200,"查询成功",questionAndAnswers);
//        }
//        return new Result<>(500,"查询失败");
//    }
//
//    @GetMapping("/question/getByStatus")
//    public Result<PageInfo> queryAnswerQuestionByEditorStatus(Page page,@RequestParam String editorStatus,HttpServletRequest httpServletRequest) {
//        String token = TokenUtil.getRequestToken(httpServletRequest);
//        SysToken sysToken = shiroService.findByToken(token);
//        PageInfo<QuestionAndAnswer> answerPageInfo = questionAnswerService.queryAnswerQuestionByEditorStatus(page, editorStatus, sysToken);
//        if (answerPageInfo != null) {
//            return new Result<PageInfo>(200,"查询成功",answerPageInfo);
//        }
//        return new Result<>(500,"查询失败");
//    }

    @GetMapping("/question/getAll")
    public Result<PageInfo> queryAnswerQuestionByEditorStatus(Page page, QuestionAndAnswer questionAndAnswer, DateDTO dateDTO,HttpServletRequest httpServletRequest) {
        String token = TokenUtil.getRequestToken(httpServletRequest);
        SysToken sysToken = shiroService.findByToken(token);
        PageInfo<QuestionAndAnswer> answerPageInfo = questionAnswerService.queryAllQuestion(page, sysToken,questionAndAnswer,dateDTO);
        if (answerPageInfo != null) {
            return new Result<PageInfo>(200,"查询成功",answerPageInfo);
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
    public Result updateOneQuestion(@RequestBody QuestionAndAnswer questionAndAnswer,HttpServletRequest httpServletRequest) {
        String token = TokenUtil.getRequestToken(httpServletRequest);
        SysToken sysToken = shiroService.findByToken(token);
        questionAndAnswer.setUserId(sysToken.getUserId());
        questionAndAnswer.setEditorStatus("1");
        questionAndAnswer.setAnswerScore("1");
        questionAndAnswer.setUpdateTime(new Date());
        Integer res = questionAnswerService.updateOneQuestion(questionAndAnswer);
        if (res >= 1) {
            return new Result<>(200,"更新成功",null);
        }
        return new Result<>(500,"更新失败");
    }

    @PostMapping("/question/insertOne")
    public Result insertOneQuestion(@RequestBody QuestionAndAnswer questionAndAnswer,HttpServletRequest httpServletRequest) throws ParseException {
        String token = TokenUtil.getRequestToken(httpServletRequest);
        SysToken sysToken = shiroService.findByToken(token);
        questionAndAnswer.setCreateTime(new Date());
        questionAndAnswer.setAnswerScore("1");
        questionAndAnswer.setEditorStatus("1");
        questionAndAnswer.setUserId(sysToken.getUserId());
        Integer res = questionAnswerService.insertOneQuestion(questionAndAnswer);
        if (res >= 1) {
            return new Result<>(200,"新增成功",null);
        }
        return new Result<>(500,"新增失败");
    }

    /**
     *
     * @param questionAndAnswer
     * @return
     * @throws ParseException
     */
//    @PostMapping("/question/insertFromStudent")
//    public Result insertOneFromStudent(@RequestBody QuestionAndAnswer questionAndAnswer) throws ParseException {
//        questionAndAnswer.setCreateTime(new Date());
//        Integer res = questionAnswerService.insertOneQuestion(questionAndAnswer);
//        if (res >= 1) {
//            return new Result<>(200,"新增成功",null);
//        }
//        return new Result<>(500,"新增失败");
//    }

    /**
     * 导入
     *
     * @param file
     */
//    @RequestMapping(value = "/question/import", method = RequestMethod.POST)
//    public Result importExcel(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
//        long start = System.currentTimeMillis();
//        List<QuestionAndAnswer> questionAndAnswerList = ExcelUtils.importExcel(file, QuestionAndAnswer.class);
////        Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse(new Date().toString());
//        for (QuestionAndAnswer QuestionAndAnswer : questionAndAnswerList) {
////            QuestionAndAnswer.setUpdateTime(sdf);
//            if (QuestionAndAnswer.getId() != null) {
//                QuestionAndAnswer.setUpdateTime(new Date());
//                questionAnswerService.updateOneQuestion(QuestionAndAnswer);
//            }else {
//                QuestionAndAnswer.setCreateTime(new Date());
//                questionAnswerService.insertOneQuestion(QuestionAndAnswer);
//            }
//        }
//        log.debug(questionAndAnswerList.toString());
//        log.debug("导入excel所花时间：" + (System.currentTimeMillis() - start));
//        return new Result<>(200,"上传成功",questionAndAnswerList);
//    }
//
//    /**
//     * 导出
//     *
//     * @param response
//     */
//    @GetMapping(value = "/question/export")
//    public Result exportExcel(HttpServletResponse response) throws IOException {
//        long start = System.currentTimeMillis();
//        List<QuestionAndAnswer> questionAndAnswerList = questionAnswerService.queryNoAnswerQuestion();
//        if (questionAndAnswerList.size()==0) {
//            return new Result<>(500,"目前没有需要解答的问题",null);
//        }
//        log.debug("导出excel所花时间：" + (System.currentTimeMillis() - start));
//        ExcelUtils.exportExcel(questionAndAnswerList, "员工信息表", "员工信息", QuestionAndAnswer.class, "员工信息", response);
//        return new Result<>(200,"下载成功",questionAndAnswerList);
//    }
//
//    /**
//     * 导出模版
//     *
//     * @param response
//     */
//    @GetMapping(value = "/question/exportTemplate")
//    public Result exportExcelTemplate(HttpServletResponse response) throws IOException {
//        List<QuestionAndAnswerVO> questionAndAnswerList = new ArrayList<>();
//        ExcelUtils.exportExcel(questionAndAnswerList, "员工信息表模版", "员工信息", QuestionAndAnswerVO.class, "员工信息", response);
//        return new Result<>(200,"下载成功",questionAndAnswerList);
//    }
}
