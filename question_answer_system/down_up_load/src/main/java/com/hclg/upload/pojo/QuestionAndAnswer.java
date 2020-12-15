package com.hclg.upload.pojo;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAndAnswer {
    private Integer id;
    @Excel(name = "问题", orderNum = "1", width = 15)
    private String question;
    @Excel(name = "答案评分", orderNum = "4", width = 15)
    private String answerScore;
    @Excel(name = "答案", orderNum = "3", width = 15)
    private String answer;
    @Excel(name = "姓名", orderNum = "0", width = 15)
    private String userName;
    @Excel(name = "问题类型", orderNum = "2", width = 15)
    private String questionType;
    @Excel(name = "创建时间", orderNum = "5", width = 15)
    private Date createTime;
    @Excel(name = "最近更新时间", orderNum = "6", width = 15)
    private Date updateTime;
}
