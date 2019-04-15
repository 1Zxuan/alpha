package com.bittereggs.login_8001.service.impl;

import com.bittereggs.login_8001.config.RedisHelper;
import com.bittereggs.login_8001.controller.WxLoginController;
import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.entity.WxUser;
import com.bittereggs.login_8001.mapper.EmailPhoneService;
import com.bittereggs.login_8001.mapper.LoginMapper;
import com.bittereggs.login_8001.mapper.WxLoginMapper;
import com.bittereggs.login_8001.mapper.WxUserConstant;
import com.bittereggs.login_8001.service.WxLoginService;
import com.bittereggs.login_8001.util.HttpClient;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private EmailPhoneService emailPhoneService;

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Map<String, Object> wxlogin(String code) {
        Map<String,String> param = WxUserConstant.MAP;
        Map<String,Object> result = new HashMap<>();
        param.put("js_code",code);
        String wxResult = HttpClient.doGet(WxUserConstant.WX_LOGIN_URL,param);
        JSONObject jsonObject = JSONObject.fromObject(wxResult);
        String session_key = jsonObject.get("session_key").toString();
        String open_id = jsonObject.get("openid").toString();
        WxUser wxUser = new WxUser();
        wxUser.setOpenid(open_id);
//        Boolean isexist;
//        if (redisHelper.hashFindAll("WxUserList").get(open_id) == null){
//            isexist = wxLoginMapper.isexist(open_id);
//        } else {
//            isexist = false;
//        }
//        if (isexist){
//            WxUser wxUser1 = wxLoginMapper.findbyopenid(open_id);
//            if (wxUser1.getCellphone() != null){
//                //可以登录
//                result.put("msg","success");
//            } else {
//                //没用绑定过手机号
//            }
//        } else {
//            result.put("msg","first");
//        }

        Boolean isexist = wxLoginMapper.isexist(open_id);
        if (isexist){
            User user = wxLoginMapper.getUserbyopenid(open_id);
        } else {
            result.put("msg","first");
            result.put("open_id",open_id);
        }
        return result;
    }

    @Override
    public Map<String, Object> wxregister(String phone, String yzm) {
        Map<String,Object> result = new HashMap<>();
        Object rediswxyzm = redisHelper.getValue("wxregister" + phone);
        if (rediswxyzm == null){
            //不存在验证码
            result.put("msg","noyzm");
        } else {
            if (rediswxyzm.toString().equals(yzm)){
                Boolean isexist = wxLoginMapper.isexistphone(phone);
                if (isexist){
                    User user = wxLoginMapper.findbyphone(phone);
                    //直接登录
                } else {
                    result.put("msg","notexist");
                }
            } else {
                result.put("msg","erroryzm");
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> getwxphoneyzm(String phone) {
        Map<String,Object> result = new HashMap<>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(this.emailPhoneService.sendphone(phone));
            redisHelper.valuePut("wxregister" + phone,jsonObject.get("yzm"));
            redisHelper.expirse("wxregister" + phone,180, TimeUnit.MINUTES);
            result.put("msg","success");
        } catch (Exception e){
            result.put("msg","error");
            redisHelper.remove("wxregister" + phone);
        }
        return result;
    }

    @Override
    public Map<String, Object> checkwxusername(String username) {
        Map<String,Object> result = new HashMap<>();
        Boolean isexist = wxLoginMapper.checkwxusername(username);
        if (isexist) {
            result.put("msg","exist");
        } else  {
            result.put("msg","success");
        }
        return result;
    }

    @Override
    public Map<String, Object> fillinfo(String username, String password, String phone, String type, String open_id) {
        Map<String,Object> result = new HashMap<>();
        try {
            wxLoginMapper.fillinfo(username,password,phone,type);
            WxUser wxUser = new WxUser(open_id,phone);
            switch (type){
                case "1": loginMapper.addworkroominfo(username);break;
                case "2": loginMapper.addenterpriseinfo(username);break;
            }
            result.put("msg","success");
        } catch (Exception e){
            result.put("msg","error");
        }
        return result;
    }

    @Override
    public Map<String, Object> wxlogin1(JSONObject jsonObject) {
        Map<String,Object> result = new HashMap<>();
        String username = jsonObject.getString("username");
        String password = DigestUtils.md5Hex(jsonObject.getString("password"));
        Boolean isexist = wxLoginMapper.checkwxusername(username);
        if (isexist){
            User user = loginMapper.findByName(username);
            if (user.getPassword().equals(password)){
                //可以登录
                result.put("username",user.getUsername());
                result.put("cellphone",user.getCellphone());
                result.put("headimage",user.getHeadimage());
                result.put("balance",user.getBalance());
                result.put("black",user.getBlack());
                result.put("type",user.getType());
                result.put("msg","success");
            } else {
                //密码错误
                result.put("msg","wrongpwd");
            }
        } else {
            result.put("msg","wrongusername");
        }
        return result;
    }

    @Override
    public Map<String, Object> wxregister1(JSONObject jsonObject) {
        Map<String,Object> result = new HashMap<>();
        String username = jsonObject.getString("username");
        String password = DigestUtils.md5Hex(jsonObject.getString("password"));
        String phone = jsonObject.getString("phone");
        Integer type = Integer.valueOf(jsonObject.getString("type"));
        String yzm = jsonObject.getString("yzm");
        Object rediswxyzm = redisHelper.getValue("wxregister" + phone);
        if (rediswxyzm == null){
            //不存在验证码
            result.put("msg","noyzm");
        } else {
            if (rediswxyzm.toString().equals(yzm)){
               User user = new User();
               user.setUsername(username);
               user.setPassword(password);
               user.setCellphone(phone);
               user.setType(type);
               try {
                   loginMapper.add(user);
                   switch (type){
                       case 1: loginMapper.addworkroominfo(username);break;
                       case 2: loginMapper.addenterpriseinfo(username);break;
                   }
                   result.put("msg","success");
               } catch (Exception e){
                   result.put("msg","error");
               }

            } else {
                result.put("msg","erroryzm");
            }
        }
        return result;
    }
}
