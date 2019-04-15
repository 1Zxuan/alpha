package com.bittereggs.login_8001.service.impl;

import com.bittereggs.login_8001.config.JsonDateValueProcessor;
import com.bittereggs.login_8001.config.RedisHelper;
import com.bittereggs.login_8001.entity.Admin;
import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.mapper.EmailPhoneService;
import com.bittereggs.login_8001.mapper.LoginMapper;
import com.bittereggs.login_8001.service.LoginService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
                //加密用户登录密码
                user.setPassword(DigestUtils.md5Hex(user.getPassword()));
                this.loginMapper.add(user);
                String paypassword = DigestUtils.md5Hex(user.getCellphone().substring(user.getCellphone().length()-6));
                //设置默认支付密码为手机号后六位
                this.loginMapper.setpaypassword(user.getUsername(),paypassword);
                //设置缓存信息
                RedisHelper.hashPut("UserList",user.getUsername(),user.toString());//添加用户缓存信息
                RedisHelper.hashPut("UserPayPassword",user.getUsername(),paypassword);//设置用户的默认支付密码
                RedisHelper.hashPut("UserPhoneList",user.getCellphone(),user.toString());//用户通过手机号登录
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
        Object redis_user = RedisHelper.hashFindAll("UserList").get(name);
        if(redis_user == null){
            user = this.loginMapper.findByName(name);
        }else {
            user = (User) JSONObject.toBean(JSONObject.fromObject(redis_user),User.class);
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
        Boolean can;
        if (redisphoenyzm == null){
            //检索数据库是否存在手机号
            User user = loginMapper.findByphone(phone);
            if (user == null)
            {
                //json.put("msg","errorphone");
                can = false;
            }
            else {
                can = true;
            }
        } else {
            can = false;
        }
        if (can){
            if (yzm.equals(redisphoenyzm.toString())){
                Object redisphoenuser = RedisHelper.hashGet("UserPhoneList",phone);
                if ( redisphoenuser == null){
                    JsonConfig jsonConfig = new JsonConfig();
                    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
                    json = JSONObject.fromObject(this.loginMapper.findByphone(phone),jsonConfig);
                    RedisHelper.hashPut("UserPhoneList",phone,json.toString());
                }else {
                    json = JSONObject.fromObject(redisphoenuser);
                }
                json.put("msg","success");
            }else {
                json.put("msg","error");
            }
        }else {
            json.put("msg","errorphone");
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
        //判断手机号是否能进行登录
        Object UserPhoneList = RedisHelper.hashFindAll("UserPhoneList").get(phone);
        Boolean can;
        if (UserPhoneList != null){
            can = true;//可以发送验证码
        }else {
            User user = loginMapper.findByphone(phone);
            if (user == null)
                can = false;//不可以发送验证码
            else
                can = true;
        }
        if (can){
            try {
                jsonObject = JSONObject.fromObject(this.emailPhoneService.sendphone(phone));
                RedisHelper.valuePut(phone+"yzm",jsonObject.get("yzm"));
                RedisHelper.expirse(phone+"yzm",5,TimeUnit.MINUTES);
                jsonObject.remove("yzm");
                jsonObject.put("msg","success");
            } catch (Exception e){
                e.printStackTrace();
                jsonObject.put("msg","error");
            }
        } else {
            jsonObject.put("msg","errorphone");
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

    @Override
    public String adminlogin(Admin admin) {
        Admin temp ;
        JSONObject jsonObject = new JSONObject();
        Object redisadmin = RedisHelper.hashGet("AdminList",admin.getUsername());
        if (redisadmin != null){
            temp = (Admin) JSONObject.toBean(JSONObject.fromObject(redisadmin),Admin.class);
        } else {
            temp = this.loginMapper.adminlogin(admin);
            if (temp != null){
                RedisHelper.hashPut("AdminList",temp.getUsername(),temp.toString());
            } else {
                //返回报错:缓存中没有数据，数据库也没有查询出结果
                jsonObject.put("msg","error");
                return jsonObject.toString();
            }
        }
        if (temp.getPassword().equals(admin.getPassword()))
            jsonObject.put("msg","success");
        else{
            jsonObject.put("msg","wrongpassword");
        }
        return jsonObject.toString();
    }

    @Override
    public String registeryzm(String phone) {
        JSONObject jsonObject = new JSONObject();
        Object UserPhoneList = RedisHelper.hashGet("UserPhoneList",phone);
        if (UserPhoneList == null){
            try {
                jsonObject = JSONObject.fromObject(this.emailPhoneService.sendphone(phone));
                RedisHelper.valuePut(phone+"registeryzm",jsonObject.get("yzm"));
                RedisHelper.expirse(phone+"registeryzm",5,TimeUnit.MINUTES);
                jsonObject.remove("yzm");
                jsonObject.put("msg","success");
            } catch (Exception e){
                jsonObject.put("msg","error");
            }
        } else {
            jsonObject.put("msg","errorphone");
        }
        return jsonObject.toString();
    }

    @Override
    public Boolean checkregisteryzm(String phone, String yzm) {
        Object checkregisteryzm = RedisHelper.getValue(phone+"registeryzm");
        if (checkregisteryzm == null){
            return false;
        } else {
            if (yzm.equals(checkregisteryzm.toString())){
                RedisHelper.remove(phone+"registeryzm");
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public String checkusername(String username) {
        JSONObject jsonObject = new JSONObject();
        Boolean isexist = loginMapper.checkusername(username);
        if (isexist){
            //用户名存在
            jsonObject.put("msg","error");
        } else {
            //用户名不存在
            jsonObject.put("msg","success");
        }
        return jsonObject.toString();
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
