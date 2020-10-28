package com.hclg.hc_confirm_order.controller;


import com.hclg.hc_confirm_order.common.CodeMsg;
import com.hclg.hc_confirm_order.common.Result;
import com.hclg.hc_confirm_order.pojo.UserInfo;
import com.hclg.hc_confirm_order.service.GetCodeUrlService;
import com.hclg.hc_confirm_order.service.GetUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.io.IOException;

@RestController
@RequestMapping("wx")
@CrossOrigin(origins = "*",allowCredentials = "true")
public class WxloginController {
    private final Logger logger = LoggerFactory.getLogger(WxloginController.class);

    @Autowired
    private GetCodeUrlService wxLoginService;
    @Autowired
    private GetUserInfoService getUserInfoService;


    /**
     * 获取code链接url
     *
     * @return
     * @throws
     * @parameter
     */
    @RequestMapping(value = "/getCodeUrl", method = RequestMethod.GET)
    public String wxLogin(){
        String getCodeUrl = wxLoginService.wxLogin();
        return getCodeUrl;
    }

    /**
     * 公众号微信登录授权回调函数
     *
     * @return
     * @throws ServletException
     * @throws IOException
     * @parameter
     */
    @RequestMapping(value = "/callBack", method = RequestMethod.GET)
    @ResponseBody
    public Result<UserInfo> callBack(String code){
        UserInfo userInfo = null;
        try {
            userInfo = getUserInfoService.getUserInfo(code);
        } catch (IOException e) {
            logger.error("调用微信获取userInfo失败");
            return Result.error(CodeMsg.UNKNOW_ERROR,"未知错误");
        }
        return Result.success(userInfo);
    }

}
