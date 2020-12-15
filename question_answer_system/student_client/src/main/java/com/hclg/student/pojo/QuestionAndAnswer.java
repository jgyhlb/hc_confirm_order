package com.hclg.student.pojo;


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
    private Integer id;
    private String question;
    private String answerScore;
    private String answer;
    private String userName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @JsonFormat(pattern= "yyyy-MM-dd")
    private Date updateTime;
    private String editorStatus;
    private Integer userId;
}
