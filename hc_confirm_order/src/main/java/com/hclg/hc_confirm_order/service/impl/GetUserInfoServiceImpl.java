package com.hclg.hc_confirm_order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hclg.hc_confirm_order.pojo.UserInfo;
import com.hclg.hc_confirm_order.service.GetUserInfoService;
import com.hclg.hc_confirm_order.utils.AuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class GetUserInfoServiceImpl implements GetUserInfoService {


    private final Logger logger = LoggerFactory.getLogger(GetUserInfoServiceImpl.class);

    @Override
    public UserInfo getUserInfo(String code) throws IOException {
        System.out.println("进如回调函数");
        // 第二步：通过code换取网页授权access_token
        String getTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtil.APPID + "&secret="
                + AuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
        logger.info("获取token,getTokenUrl=" + getTokenUrl);
        JSONObject getTokenJson = AuthUtil.doGetJson(getTokenUrl);
        /*
         * { "access_token":"ACCESS_TOKEN", "expires_in":7200,
         * "refresh_token":"REFRESH_TOKEN", "openid":"OPENID", "scope":"SCOPE" }
         */
        logger.info("获取token,getTokenJson=" + getTokenJson.toJSONString());

        String openid = getTokenJson.getString("openid");
        String access_token = getTokenJson.getString("access_token");
        String refresh_token = getTokenJson.getString("refresh_token");

        // 第五步验证access_token是否失效；展示都不需要
        String vlidTokenUrl = "https://api.weixin.qq.com/sns/auth?access_token=" + access_token + "&openid=" + openid;
        logger.info("验证token,vlidTokenUrl=" + vlidTokenUrl);
        JSONObject validTokenJson = AuthUtil.doGetJson(vlidTokenUrl);
        logger.info("验证token,validTokenJson=" + validTokenJson.toJSONString());
        if (!"0".equals(validTokenJson.getString("errcode"))) {
            // 第三步：刷新access_token（如果需要）-----暂时没有使用,参考文档https://mp.weixin.qq.com/wiki，
            String refreshTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + openid
                    + "&grant_type=refresh_token&refresh_token=" + refresh_token;
            logger.info("刷新token,refreshTokenUrl=" + refreshTokenUrl);
            JSONObject refreshTokenJson = AuthUtil.doGetJson(refreshTokenUrl);
            /*
             * { "access_token":"ACCESS_TOKEN", "expires_in":7200,
             * "refresh_token":"REFRESH_TOKEN", "openid":"OPENID", "scope":"SCOPE" }
             */
            logger.info("刷新token,refreshTokenJson=" + refreshTokenJson.toJSONString());
            access_token = refreshTokenJson.getString("access_token");
        }

        // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
        String getUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid
                + "&lang=zh_CN";
        logger.info("获取用户信息，getUserInfoUrl=" + getUserInfoUrl.toString());
        JSONObject getUserInfoJson = AuthUtil.doGetJson(getUserInfoUrl);
        logger.info("获取用户信息，getUserInfoJson=" + getUserInfoJson.toString());
        UserInfo userInfo = getUserInfoJson.toJavaObject(UserInfo.class);
        logger.info("userInfo=:"+userInfo);
        return userInfo;
    }
}
