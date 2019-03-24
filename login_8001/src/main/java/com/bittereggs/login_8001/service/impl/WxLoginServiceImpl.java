package com.bittereggs.login_8001.service.impl;

import com.bittereggs.login_8001.config.RedisHelper;
import com.bittereggs.login_8001.controller.WxLoginController;
import com.bittereggs.login_8001.entity.WxUser;
import com.bittereggs.login_8001.mapper.WxLoginMapper;
import com.bittereggs.login_8001.mapper.WxUserConstant;
import com.bittereggs.login_8001.service.WxLoginService;
import com.bittereggs.login_8001.util.HttpClient;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 楼中煊
 * @data 2019/3/19
 * @time 14:17
 */
@Service
public class WxLoginServiceImpl implements WxLoginService {

    @Autowired
    private RedisHelper redisHelper;

    @Autowired
    private WxLoginMapper wxLoginMapper;


    @Override
    public WxUser findbyopenid(String openid) {
        return wxLoginMapper.findbyopenid(openid);
    }

    @Override
    public void addwxuser(WxUser wxUser) {
        wxLoginMapper.addwxuser(wxUser);
    }

    @Override
    public Map<String, Object> wxlogin(String code) {
        Map<String,String> param = WxUserConstant.MAP;
        param.put("js_code",code);
        String wxResult = HttpClient.doGet(WxUserConstant.WX_LOGIN_URL,param);
        JSONObject jsonObject = JSONObject.fromObject(wxResult);
        String session_key = jsonObject.get("session_key").toString();
        String open_id = jsonObject.get("openid").toString();
        WxUser wxUser = new WxUser();
        wxUser.setOpenid(open_id);
        if (redisHelper.hashFindAll("WxUserList").get(open_id) == null){
            //缓冲为空
            WxUser wxUser1 = findbyopenid(open_id);
            if ( wxUser1 == null){
                System.out.println("添加用户");
                //微信用户表数据为空，插入用户信息
                redisHelper.hashPut("WxUserList",open_id,wxUser.toString());
                addwxuser(wxUser);
            }else{
                //微信用户表有数据，判断是否已经绑定用户
                if (wxUser1.getUsername() == null){
                    //没有绑定用户
                }else {
                    //判定了用户
                }
            }
        }
        return null;
    }
}
