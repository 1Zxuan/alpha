package com.bittereggs.admin_8009.service.impl;

import com.bittereggs.admin_8009.entity.User;
import com.bittereggs.admin_8009.mapper.UserManagerMapper;
import com.bittereggs.admin_8009.service.UserManagerService;
import com.bittereggs.admin_8009.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    private UserManagerMapper userManagerMapper;

    @Override
    public String getUser() {
        JSONArray jsonArray;
        List<User> list = userManagerMapper.getUser();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray.toString();
    }

    @Override
    public String upUser(User user) {
        JSONObject jsonObject = new JSONObject();
        try{
            userManagerMapper.upUser(user);
            jsonObject.put("msg","success");
        }catch (Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }

    @Override
    public String delUser(String username) {
        JSONObject jsonObject = new JSONObject();
        try{
            userManagerMapper.delUser(username);
            jsonObject.put("msg","success");
        }catch (Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }
}
