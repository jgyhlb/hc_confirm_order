package com.hclg.question.pojo;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAndAnswer implements Serializable {
    @Excel(name = "序号", orderNum = "0", width = 15)
    private Integer id;
    @Excel(name = "问题", orderNum = "2", width = 15)
    private String question;
    @Excel(name = "答案评分", orderNum = "5", width = 15)
    private String answerScore;
    @Excel(name = "答案", orderNum = "4", width = 15)
    private String answer;
    @Excel(name = "创建人", orderNum = "1", width = 15)
    private String userName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @JsonFormat(pattern= "yyyy-MM-dd")
    private Date updateTime;
    private String editorStatus;
    private Integer userId;
}
