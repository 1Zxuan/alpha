package com.bittereggs.admin_8009.service.impl;

import com.bittereggs.admin_8009.entity.Blacklist;
import com.bittereggs.admin_8009.entity.Report;
import com.bittereggs.admin_8009.mapper.BlacklistMapper;
import com.bittereggs.admin_8009.mapper.ReportMapper;
import com.bittereggs.admin_8009.service.ReportService;
import com.bittereggs.admin_8009.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private BlacklistMapper blacklistMapper;

    @Override
    public String getReport(Report report) {
        JSONArray jsonArray;
        List<Report> list =reportMapper.getReport(report);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray.toString();
    }

    @Override
    public String addReport(Report report) {
        JSONObject jsonObject = new JSONObject();
        try {
            reportMapper.addReport(report);
            jsonObject.put("msg","success");
        }catch(Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }

    @Override
    public String upReport(Report report) {
        JSONObject jsonObject = new JSONObject();
        try {

            reportMapper.upReport(report);
            if(report.getComplain_res()==2){
                Blacklist blacklist = new Blacklist();
                blacklist.setName(report.getRespond_username());
                blacklist.setReason(report.getComplain_content());
                blacklistMapper.addBlackList(blacklist);
            }
            jsonObject.put("msg","success");
        }catch(Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }
}
