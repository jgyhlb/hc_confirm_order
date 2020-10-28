package com.hclg.hc_confirm_order.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class AuthUtil {
    //后厂appid
        public static final String APPID = "wx76cd575cad527acd";
        public static final String APPSECRET = "668cf02086127dba607069c33322f3a9";
//        测试号appid
//        public static final String APPID = "wxcc3d77ca0ab7f806";
//        public static final String APPSECRET = "f840c97b35ecde78606ad872c5f1e532";

        public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
            JSONObject jsonObject = null;
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 把返回的结果转换为JSON对象
                String result = EntityUtils.toString(entity, "UTF-8");
                jsonObject = JSON.parseObject(result);
            }
            return jsonObject;
        }

    }
