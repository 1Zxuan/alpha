package com.alpha.findinfromatin_8003.service.impl;

import com.alpha.findinfromatin_8003.config.RedisHelper;
import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.WorkRoom;
import com.alpha.findinfromatin_8003.mapper.FindInformationMapper;
import com.alpha.findinfromatin_8003.service.FindInfomationService;
import com.alpha.findinfromatin_8003.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service(value = "FindInfomationService")
public class FindInformationServiceImpl implements FindInfomationService {

    @Autowired
    private FindInformationMapper findInformationMapper;

    @Autowired
    private RedisHelper redisHelper;

    @Override
    public String getAllWorkRoom(String page,String goodfield){
        JSONArray jsonArray;
        //Object redisAllWorkRoom = redisHelper.hashGet("AllWorkRoom_Page",page);
        //if (redisAllWorkRoom == null){
            int p;
            if(Integer.parseInt(page) >=1){
                p = Integer.parseInt(page)*10+1;
            }else{
                p=0;
            }
            if(goodfield == "")
                goodfield=null;
            List<WorkRoom> list =findInformationMapper.getAllWorkRoom(p,goodfield);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            jsonArray = JSONArray.fromObject(list,jsonConfig);
            //redisHelper.hashPut("AllWorkRoom_Page",page,jsonArray.toString());
//        }else {
//            jsonArray = JSONArray.fromObject(redisAllWorkRoom);
//        }
        return jsonArray.toString();
    }

    @Override
    public String searchWorkRoom(String key) {
        List<WorkRoom> list = findInformationMapper.searchWorkRoom(key);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray.toString();
    }

    @Override
    public String getWorkRoom(String workroom_username) {
        JSONObject json;
        Object redisWorkRoom = redisHelper.hashGet("WorkRoom",workroom_username);
        if (redisWorkRoom == null){
            WorkRoom workRoom =findInformationMapper.getWorkRoom(workroom_username);
            json = JSONObject.fromObject(workRoom);
            redisHelper.hashPut("WorkRoom",workroom_username,json.toString());
        } else {
            json = JSONObject.fromObject(redisWorkRoom);
        }
        return json.toString();
    }

    @Override
    public String getEnterprise(String company_username) {
        JSONObject json;
        Object redisEnterprise = redisHelper.hashGet("EnterPrise",company_username);
        if (redisEnterprise == null){
            Enterprise enterprise = findInformationMapper.getEnterprise(company_username);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            json = JSONObject.fromObject(enterprise,jsonConfig);
            redisHelper.hashPut("EnterPrise",company_username,json.toString());
        }else {
            json = JSONObject.fromObject(redisEnterprise);
        }
        return json.toString();
    }
}

