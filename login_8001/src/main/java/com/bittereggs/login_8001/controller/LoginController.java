package com.bittereggs.login_8001.controller;

import com.bittereggs.login_8001.config.RedisHelper;
import com.bittereggs.login_8001.entity.Admin;
import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.service.LoginService;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisHelper redisHelper;

    //注册判断用户名是否已存在
    @RequestMapping(method = RequestMethod.POST, value = "/checkusername", consumes = "application/json")
    public String checkusername(@RequestBody User user){
        return loginService.checkusername(user.getUsername());
    }

    //注册
    @RequestMapping(method = RequestMethod.POST,value = "/register",consumes = "application/json")
    public String register(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        if (loginService.checkregisteryzm(user.getCellphone(),user.getYzm())){
            user.setYzm("");
            if(this.loginService.add(user)){
                jsonObject.put("msg","success");
            }else {
                jsonObject.put("msg","error");
            }
        } else {
            jsonObject.put("msg","erroryzm");
        }
        return jsonObject.toString();
    }

    //登录
    @RequestMapping(method = RequestMethod.POST,value = "/login",consumes = "application/json")
    public String login(@RequestBody User user){
        System.out.println(user.getUsername()+user.getPassword());
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), DigestUtils.md5Hex(user.getPassword()));
        try {
           subject.login(token);
           jsonObject = JSONObject.fromObject(redisHelper.hashFindAll("UserList").get(token.getUsername()));
           jsonObject.remove("password");
           jsonObject.remove("yzm");
           jsonObject.put("msg","success");
            return jsonObject.toString();
        }catch(UnknownAccountException e) {
            //用户名不存在
            jsonObject.put("msg","error");
            return jsonObject.toString();
        }catch(IncorrectCredentialsException e){
            //密码错误
            jsonObject.put("msg","wrongpwd");
            return jsonObject.toString();
        }
    }

    //注册发起手机验证码
    @GetMapping("/registeryzm")
    public String registeryzm(@RequestParam("cellphone") String phone){
        return loginService.registeryzm(phone);
    }

    //管理员登录
    @RequestMapping(method = RequestMethod.POST,value = "/adminlogin")
    public String adminlogin(@RequestBody Admin admin){
        return this.loginService.adminlogin(admin);
    }

    //忘记密码发起邮箱验证
    @RequestMapping(method = RequestMethod.GET,value = "/getyzm")
    public String getyzm(@RequestParam("username")String username,@RequestParam("email")String email){
        String result = loginService.getyzm(username,email);
        return result;
    }

    //发起手机验证码登录
    @RequestMapping(method = RequestMethod.GET,value = "/getphoneloginyzm")
    public String getphoneloginyzm(@RequestParam("phone") String phone){
        String result = this.loginService.getphoneloginyzm(phone);
        return result;
    }

    //手机号验证登录
    @RequestMapping(method = RequestMethod.POST,value = "/checkphonelogin",consumes = "application/json")
    public String checkphonelogin(@RequestBody JSONObject data){
        String result = this.loginService.phonelogin(data.get("phone").toString(),data.get("yzm").toString());
        return result;
    }

    //验证邮箱验证码
    @RequestMapping(method = RequestMethod.POST,value = "/checkyzm")
    public String checkyzm(@RequestParam("username") String username, @RequestParam("yzm") String yzm){
        JSONObject jsonObject = new JSONObject();
       if (this.loginService.checkyzm(username,yzm)){
           jsonObject.put("msg","success");
       }else {
           jsonObject.put("msg","error");
       }
       return jsonObject.toString();
    }

    //重置密码
    @RequestMapping(method = RequestMethod.POST,value = "/resetpassword",consumes = "application/json")
    public String resetpassword(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        if (loginService.resetpassword(user)){
            jsonObject.put("msg","success");
        }else {
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(@RequestParam("name")String name){
        return "test";
    }


}
