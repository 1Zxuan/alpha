package com.alpha.findinfromatin_8003.service.impl;

import com.alpha.findinfromatin_8003.entity.BiddingBook;
import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.User;
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


@Service
public class FindInformationServiceImpl implements FindInfomationService {

    @Autowired
    private FindInformationMapper findInformationMapper;

 /*   @Override
    public List<BiddingBook> getBeforBiddingbook(String company_username) {

        return findInformationMapper.getBeforBiddingbook(company_username);
    }*/


 /*   @Override
    public List<BiddingBook> getAllBiddingBook(String page,String order) {
        int p;
        if(Integer.parseInt(page) >=1 ){
            p = Integer.parseInt(page)*10+1;
        }else{
            p=0;
        }
        return findInformationMapper.getAllBiddingBook(p,order);
    }*/


    @Override
    public String getAllWorkRoom(String page) {
        int p;
        if(Integer.parseInt(page) >=1 ){
            p = Integer.parseInt(page)*10+1;
        }else{
            p=0;
        }
        List<WorkRoom> list = findInformationMapper.getAllWorkRoom(p);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
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
        WorkRoom workRoom = new WorkRoom();
        workRoom = findInformationMapper.getWorkRoom(workroom_username);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject jsonObject = JSONObject.fromObject(workRoom,jsonConfig);
        return jsonObject.toString();
    }

    @Override
    public String getEnterprise(String company_username) {
        Enterprise enterprise = findInformationMapper.getEnterprise(company_username);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject jsonObject = JSONObject.fromObject(enterprise,jsonConfig);
        return jsonObject.toString();
    }

    @Override
    public String getUserInfo(String username) {
        try {
            User user = findInformationMapper.getUserInfo(username);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            JSONObject jsonObject = JSONObject.fromObject(user, jsonConfig);
            return jsonObject.toString();
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg","error");
            return  jsonObject.toString();
        }
    }



}

