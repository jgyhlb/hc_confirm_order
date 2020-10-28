package com.hclg.hc_confirm_order.service.impl;

import com.hclg.hc_confirm_order.dao.EnterStudyRegisterDao;
import com.hclg.hc_confirm_order.pojo.EnterStudyRegister;
import com.hclg.hc_confirm_order.service.EnterStudyRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EnterStudyRegisterServiceImpl implements EnterStudyRegisterService {

    @Resource
    private EnterStudyRegisterDao enterStudyRegisterDao;

    private final Logger logger = LoggerFactory.getLogger(EnterStudyRegisterServiceImpl.class);

    @Override
    public Integer saveInfo(EnterStudyRegister enterStudyRegister) {
        try {
            enterStudyRegisterDao.saveInfo(enterStudyRegister);
            return 0;
        }catch (Exception e){
            logger.info(enterStudyRegister.toString());
            logger.error("插入学生注册信息失败"+e.toString());
            e.printStackTrace();
            return 1;
        }
    }
}
