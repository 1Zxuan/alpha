package com.bittereggs.login_8001.service.impl;

import com.bittereggs.login_8001.config.JsonDateValueProcessor;
import com.bittereggs.login_8001.config.RedisHelper;
import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.mapper.EmailPhoneService;
import com.bittereggs.login_8001.mapper.LoginMapper;
import com.bittereggs.login_8001.service.LoginService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private RedisHelper RedisHelper;

    @Autowired
    private EmailPhoneService emailPhoneService;

    @Override
    public Boolean add(User user) {
        //先判断redis_用户名是否已经存在
        if(RedisHelper.hashFindAll("UserList").get(user.getUsername()) == null){
            //缓存为空，判断数据库
            User user1 = this.loginMapper.findByName(user.getUsername());
            if(user1 == null){
                this.loginMapper.add(user);
                RedisHelper.hashPut("UserList",user.getUsername(),user.toString());
                switch (user.getType()){
                    case 1: loginMapper.addworkroominfo(user.getUsername());break;
                    case 2: loginMapper.addenterpriseinfo(user.getUsername());break;
                }
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public User findByName(String name) {
        User user;
        JSONObject redis_user = JSONObject.fromObject(RedisHelper.hashFindAll("UserList").get(name));
        if(redis_user.isEmpty()){
            user = this.loginMapper.findByName(name);
        }else {
            user = (User) JSONObject.toBean(redis_user,User.class);
        }
        return user;
    }

    @Override
    public String getuserinfo(String username) {
        JSONObject userinfo = JSONObject.fromObject(RedisHelper.hashFindAll("UserList").get(username));
        return userinfo.toString();
    }

    @Override
    public String phonelogin(String phone, String yzm) {
        //验证
        Object redisphoenyzm = RedisHelper.getValue(phone+"yzm");
        JSONObject json = new JSONObject();
        if (redisphoenyzm ==null){
            json.put("msg","error");
        } else {
            if (yzm.equals(redisphoenyzm.toString())){
                Object redisphoenuser = RedisHelper.hashGet("PhoneUserList",phone);
                if ( redisphoenuser == null){
                    JsonConfig jsonConfig = new JsonConfig();
                    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
                    json = JSONObject.fromObject(this.loginMapper.findByphone(phone),jsonConfig);
                    RedisHelper.hashPut("PhoneUserList",phone,json.toString());
                }else {
                    json = JSONObject.fromObject(redisphoenuser);
                }
                json.put("msg","success");
            }else {
                json.put("msg","error");
            }
        }
        return json.toString();
    }

    @Override
    public String getyzm(String username, String email) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = JSONObject.fromObject(this.emailPhoneService.sendmail(email));
            RedisHelper.valuePut(username+"yzm",jsonObject.get("yzm"));
            RedisHelper.expirse(username+"yzm",5, TimeUnit.MINUTES);
            jsonObject.remove("yzm");
            jsonObject.put("msg","success");
        }catch (Exception e){
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }

    @Override
    public String getphoneloginyzm(String phone) {

        //调用手机验证码服务发送验证码，并存入缓存
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = JSONObject.fromObject(this.emailPhoneService.sendphone(phone));
            RedisHelper.valuePut(phone+"yzm",jsonObject.get("yzm"));
            RedisHelper.expirse(phone+"yzm",5,TimeUnit.MINUTES);
            jsonObject.remove("yzm");
            jsonObject.put("msg","success");
        } catch (Exception e){
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }

    @Override
    public Boolean checkyzm(String username, String yzm) {

            Object redisyzm = RedisHelper.getValue(username+"yzm");
            if ( redisyzm == null){
                return false;
            } else {
                if (redisyzm.toString().equals(yzm)){
                    RedisHelper.remove(username+"yzm");
                    return true;
                }
            }
        return false;
    }

    @Override
    public Boolean resetpassword(User user) {
        try {
            //清空缓存数据
            RedisHelper.hashRemove("UserList",user.getUsername());
        } catch (Exception e){
            e.printStackTrace();
        }
        //操作数据库
        User user1 = this.loginMapper.findByName(user.getUsername());
        if(user1 == null){
            return false;
        }else {
            this.loginMapper.resetpassword(user);
            return true;
        }
    }

//    public Boolean login(User user) {
//        ValueOperations<String,User> operations = redisTemplate.opsForValue();
//        Boolean exist = redisTemplate.hasKey(user);
//        if(exist){
//            return true;
//        }else{
//            exist = this.loginMapper.login(user);
//            if(exist){
//                return exist;
//            }else
//                return exist;
//        }
//    }

}
