package com.hclg.question.dao;

import com.hclg.question.pojo.SysToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysTokenDao {
    /**
     * 通过token查找
     * @param token
     * @return
     */
    SysToken findByToken(@Param("token") String token);

    /**
     * 通过userID查找
     * @param userId
     * @return
     */
    SysToken findByUserId(@Param("userId") Integer userId);

    Integer save(SysToken tokenEntity);

    Integer update(SysToken tokenEntity);
}
