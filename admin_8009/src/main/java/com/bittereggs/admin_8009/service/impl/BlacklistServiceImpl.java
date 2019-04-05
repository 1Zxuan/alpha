package com.bittereggs.admin_8009.service.impl;

import com.bittereggs.admin_8009.entity.Blacklist;
import com.bittereggs.admin_8009.mapper.BlacklistMapper;
import com.bittereggs.admin_8009.service.BlacklistService;
import com.bittereggs.admin_8009.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class BlacklistServiceImpl implements BlacklistService {

    @Autowired
    private BlacklistMapper blacklistMapper;

    @Override
    public String getBlackList(Blacklist blacklist) {
        JSONArray jsonArray;
        List<Blacklist> list =blacklistMapper.getBlackList(blacklist);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray.toString();
    }

    @Override
    public String addBlackList(Blacklist blacklist) {
        JSONObject jsonObject = new JSONObject();
        try {
            blacklistMapper.addBlackList(blacklist);
            jsonObject.put("msg","success");
        }catch (Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }

        return jsonObject.toString();
    }

    @Override
    public String delBlackList(String name) {
        JSONObject jsonObject = new JSONObject();
        try {
            blacklistMapper.delBlackList(name);
            jsonObject.put("msg","success");
        }catch (Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }

        return jsonObject.toString();
    }



}
