package com.bittereggs.admin_8009.service.impl;

import com.bittereggs.admin_8009.entity.Enterprise_aud;
import com.bittereggs.admin_8009.entity.Workroom_aud;
import com.bittereggs.admin_8009.mapper.AuditingMapper;
import com.bittereggs.admin_8009.service.AuditingService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditingServiceImpl implements AuditingService {

    @Autowired
    private AuditingMapper auditingMapper;

    @Override
    public String getWorkroomAud(Workroom_aud workroom_aud) {
        List<Workroom_aud> list = auditingMapper.getWorkroomAud(workroom_aud);
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @Override
    public String getEnterpriseAud(Enterprise_aud enterprise_aud) {
        List<Workroom_aud> list = auditingMapper.getEnterpriseAud(enterprise_aud);
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @Override
    public String upPassWorkroom(Workroom_aud workroom_aud) {
        JSONObject jsonObject = new JSONObject();
        try {
            auditingMapper.upPassWorkroom(workroom_aud);
            jsonObject.put("msg","success");
        }catch(Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }

    @Override
    public String upPassEnterprise(Enterprise_aud enterprise_aud) {
        JSONObject jsonObject = new JSONObject();
        try {
            auditingMapper.upPassEnterprise(enterprise_aud);
            jsonObject.put("msg","success");
        }catch (Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }

        return jsonObject.toString();
    }



}
