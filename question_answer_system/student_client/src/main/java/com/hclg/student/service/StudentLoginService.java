package com.hclg.student.service;


import com.hclg.student.pojo.EnterStudyRegister;

public interface StudentLoginService {
    EnterStudyRegister queryEnterStudyRegisterByName(String name);
}
