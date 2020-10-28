package com.hclg.hc_confirm_order.service.impl;

import com.hclg.hc_confirm_order.service.GetCodeUrlService;
import com.hclg.hc_confirm_order.utils.AuthUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;


@Service
public class GetCodeUrlServiceImpl implements GetCodeUrlService {

    private final Logger logger = LoggerFactory.getLogger(GetCodeUrlServiceImpl.class);

    @Override
    public String wxLogin() {
        // 这个url的域名必须要进行再公众号中进行注册验证，这个地址是成功后的回调地址
//        String backUrl = "http://10.20.31.246:8020/HCYDapplyList/index.html";
        String backUrl = "https://hcydapplylist.houchangtech.com";
        // 第一步：用户同意授权，获取code
        String getCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID + "&redirect_uri="
                + URLEncoder.encode(backUrl) + "&response_type=code" + "&scope=snsapi_userinfo"
                + "&state=STATE#wechat_redirect";

        logger.info("获取code, getCodeUrl=" + getCodeUrl);
        // response.sendRedirect(url);
//        return "redirect:" + getCodeUrl;// 必须重定向，否则不能成功
        return getCodeUrl;// 必须重定向，否则不能成功
    }
}
