package com.bittereggs.login_8001.controller;

import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.service.LoginService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.POST,value = "/add",consumes = "application/json")
    public String add(@RequestBody User user){
        System.out.println("login");
//        this.loginService.add(user);
        System.out.println(user.getUsername()+user.getPassword()+user.getType());
        Map<String,Object> map = new HashMap<>();
        map.put("message",true);
        JSONArray jsonArray = JSONArray.fromObject(map);
        return jsonArray.toString();
    }
}
