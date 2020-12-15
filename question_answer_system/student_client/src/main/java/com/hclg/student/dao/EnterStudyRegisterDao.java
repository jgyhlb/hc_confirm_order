package com.hclg.student.dao;


import com.hclg.student.pojo.EnterStudyRegister;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnterStudyRegisterDao {
    EnterStudyRegister queryEnterStudyRegisterByName(String name);
}
