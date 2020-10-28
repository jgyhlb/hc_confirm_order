package com.hclg.hc_confirm_order.service;

import com.hclg.hc_confirm_order.pojo.UserInfo;

import java.io.IOException;

public interface GetUserInfoService {
    UserInfo getUserInfo(String code) throws IOException;
}
