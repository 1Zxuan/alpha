package com.bittereggs.admin_8009.service.impl;

import com.bittereggs.admin_8009.entity.Enterprise;
import com.bittereggs.admin_8009.entity.WorkRoom;
import com.bittereggs.admin_8009.mapper.AdminMapper;
import com.bittereggs.admin_8009.service.AdminService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String getWorkRoomAud(String status) {
        List<WorkRoom> list = adminMapper.getWorkRoomAud(status);
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @Override
    public String getEnterpriseAud(String status) {
        List<Enterprise> list = adminMapper.getEnterpriseAud(status);
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
}
