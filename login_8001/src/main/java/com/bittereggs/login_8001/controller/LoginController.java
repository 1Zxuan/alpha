package com.bittereggs.login_8001.controller;

import com.bittereggs.login_8001.config.RedisHelper;
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
import org.springframework.cache.annotation.Cacheable;
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

    @Autowired
    private RedisHelper redisHelper;

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
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try{
            subject.login(token);
            System.out.println("登录成功");
            return "redirect:/testThymeleaf";
        }catch(UnknownAccountException e){
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

    @ResponseBody
    @PostMapping("/test")
    public String test(){
        return "test";
    }
}
