package com.hclg.hc_confirm_order.dao;

import com.hclg.hc_confirm_order.pojo.EnteredName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnteredNameDao {
    void saveName(@Param("name") String name);
}
