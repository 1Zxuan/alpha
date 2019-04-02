package com.bittereggs.money.service.impl;

import com.bittereggs.money.entity.Advertisement;
import com.bittereggs.money.mapper.ADMapper;
import com.bittereggs.money.service.ADService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 楼中煊
 * @data 2019/4/1
 * @time 19:53
 */

@Service
public class ADServiceImpl implements ADService {

    @Autowired
    private ADMapper adMapper;

    @Override
    public String workroomapplyAD(Advertisement advertisement) {
        JSONObject result = new JSONObject();
        try {
            //添加广告位信息
            adMapper.applyAD(advertisement);
            result.put("msg","success");
        } catch (Exception e){
            result.put("msg","error");
        }
        return result.toString();
    }

    @Override
    public String companyapplyAD(Advertisement advertisement) {
        JSONObject result = new JSONObject();
        try {
            //添加广告位信息
            adMapper.applyAD(advertisement);
            result.put("msg","success");
        } catch (Exception e){
            result.put("msg","error");
        }
        return result.toString();
    }
}
