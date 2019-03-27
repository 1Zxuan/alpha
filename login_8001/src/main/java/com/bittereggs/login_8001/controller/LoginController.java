package com.bittereggs.login_8001.controller;

import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.service.LoginService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;


    //注册
    @RequestMapping(method = RequestMethod.POST,value = "/register",consumes = "application/json")
    public String register(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
       if(this.loginService.add(user)){
           map.put("msg","success");
       }else {
           map.put("msg","error");
       }
       JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    //登录
    @RequestMapping(method = RequestMethod.POST,value = "/login",consumes = "application/json")
    public String login(@RequestBody User user, Model model){

        Map<String,Object> result = new HashMap<>();
        JSONArray jsonObject;
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            result.put("msg",true);
            jsonObject = JSONArray.fromObject(result);
            return jsonObject.toString();
        }catch(UnknownAccountException e) {
            //用户名不存在
            model.addAttribute("msg","用户名不存在");
            System.out.println("用户名不存在");
            return "login";
        }catch(IncorrectCredentialsException e){
            //用户名不存在
            model.addAttribute("msg","密码错误");
            System.out.println("密码错误");
            return "login";
        }
    }

    //忘记密码发起邮箱验证
    @RequestMapping(method = RequestMethod.GET,value = "/getyzm")
    public String getyzm(@RequestParam("username")String username,@RequestParam("email")String email){
        String yzm = loginService.getyzm(username,email);
        return yzm;
    }

    //验证验证码
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

        return null;
    }


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(@RequestParam("name")String name){
        return "test";
    }
}
