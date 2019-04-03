package com.bittereggs.login_8001.mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 楼中煊
 * @data 2019/3/19
 * @time 10:31
 */
public interface WxUserConstant {

    String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";

    String WX_LOGIN_APPID = "wxbba252ddb82185e2";

    String WX_LOGIN_SECRET = "a923d0b914ef58c58553b7ff1e56b41b";

    String WX_LOGIN_GRANT_TYPE = "authorization_code";

    Map<String,String> MAP = new HashMap<String, String>(){{
        put("appid",WX_LOGIN_APPID);
        put("secret",WX_LOGIN_SECRET);
        put("grant_type",WX_LOGIN_GRANT_TYPE);
    }};

}
