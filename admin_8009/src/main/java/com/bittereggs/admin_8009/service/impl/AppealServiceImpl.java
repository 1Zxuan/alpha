package com.bittereggs.admin_8009.service.impl;

import com.bittereggs.admin_8009.entity.Appeal;
import com.bittereggs.admin_8009.entity.Report;
import com.bittereggs.admin_8009.mapper.AppealMapper;
import com.bittereggs.admin_8009.service.AppealService;
import com.bittereggs.admin_8009.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppealServiceImpl implements AppealService {
    @Autowired
    private AppealMapper appealMapper;

    @Override
    public String getAppeal(Appeal appeal) {
        JSONArray jsonArray;
        List<Report> list =appealMapper.getAppeal(appeal);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray.toString();
    }
}
