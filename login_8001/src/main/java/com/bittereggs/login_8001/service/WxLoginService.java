package com.bittereggs.login_8001.service;

import com.bittereggs.login_8001.entity.WxUser;

import java.util.Map;

/**
 * @author 楼中煊
 * @data 2019/3/19
 * @time 14:16
 */
public interface WxLoginService {

    WxUser findbyopenid(String openid);

    void addwxuser(WxUser wxUser);

    Map<String,Object> wxlogin(String code);
}
