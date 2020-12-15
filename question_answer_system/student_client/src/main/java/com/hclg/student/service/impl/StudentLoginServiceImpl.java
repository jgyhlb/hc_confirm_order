package com.hclg.student.service.impl;


import com.hclg.student.dao.EnterStudyRegisterDao;
import com.hclg.student.pojo.EnterStudyRegister;
import com.hclg.student.service.StudentLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StudentLoginServiceImpl implements StudentLoginService {
    @Resource
    private EnterStudyRegisterDao enterStudyRegisterDao;


    @Override
    public EnterStudyRegister queryEnterStudyRegisterByName(String name) {
        return enterStudyRegisterDao.queryEnterStudyRegisterByName(name);
    }
}
