package com.bittereggs.admin_8009.service.impl;

import com.bittereggs.admin_8009.entity.Appeal;
import com.bittereggs.admin_8009.entity.Report;
import com.bittereggs.admin_8009.mapper.AppealMapper;
import com.bittereggs.admin_8009.mapper.BlacklistMapper;
import com.bittereggs.admin_8009.service.AppealService;
import com.bittereggs.admin_8009.util.JsonDateValueProcessor;
import io.netty.handler.codec.json.JsonObjectDecoder;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppealServiceImpl implements AppealService {
    @Autowired
    private AppealMapper appealMapper;

    @Autowired
    private BlacklistMapper blacklistMapper;

    @Override
    public String getAppeal(Appeal appeal) {
        JSONArray jsonArray;
        List<Report> list =appealMapper.getAppeal(appeal);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray.toString();
    }

    @Override
    public String addAppeal(Appeal appeal) {
        JSONObject jsonObject= new JSONObject();
        try{
            appealMapper.addAppeal(appeal);
            jsonObject.put("msg","success");
        }catch(Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }

    @Override
    public String upAppeal(Appeal appeal) {
        JSONObject jsonObject= new JSONObject();
        //try {
            appealMapper.upAppeal(appeal);
            if (appeal.getAppeal_res() == 1)
                blacklistMapper.delBlackList(appeal.getUsername());
            jsonObject.put("msg","success");
       /* }catch(Exception e){
            jsonObject.put("msg","error");
        }*/
        return jsonObject.toString();
    }
}
