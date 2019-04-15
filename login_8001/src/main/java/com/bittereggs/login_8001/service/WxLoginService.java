package com.bittereggs.login_8001.service;

import com.bittereggs.login_8001.entity.WxUser;
import net.sf.json.JSONObject;

import java.util.Map;

/**
 * @author 楼中煊
 * @data 2019/3/19
 * @time 14:16
 */
public interface WxLoginService {

    Map<String,Object> wxlogin(String code);

    Map<String,Object> wxregister(String phone, String yzm);

    Map<String, Object> getwxphoneyzm(String phone);

    Map<String, Object> checkwxusername(String username);

    Map<String, Object> fillinfo(String username, String password, String phone, String type, String open_id);

    Map<String, Object> wxlogin1(JSONObject jsonObject);

    Map<String, Object> wxregister1(JSONObject jsonObject);
}
