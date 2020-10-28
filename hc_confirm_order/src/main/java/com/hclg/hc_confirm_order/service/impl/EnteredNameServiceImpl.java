package com.hclg.hc_confirm_order.service.impl;

import com.hclg.hc_confirm_order.dao.EnteredNameDao;
import com.hclg.hc_confirm_order.pojo.EnteredName;
import com.hclg.hc_confirm_order.service.EnteredNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EnteredNameServiceImpl implements EnteredNameService {

    @Resource
    private EnteredNameDao enteredNameDao;

    private final Logger logger = LoggerFactory.getLogger(EnterStudyRegisterServiceImpl.class);

    @Override
    public Integer saveName(String name) {
        try {
            enteredNameDao.saveName(name);
            return 0;
        }catch (Exception e){
            logger.info(name);
            logger.error("报名确认函姓名保存失败"+e.toString());
            e.printStackTrace();
            return 1;
        }
    }
}
