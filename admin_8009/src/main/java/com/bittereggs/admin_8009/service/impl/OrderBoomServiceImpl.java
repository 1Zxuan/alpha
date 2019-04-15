package com.bittereggs.admin_8009.service.impl;

import com.bittereggs.admin_8009.controller.OrderBoomController;
import com.bittereggs.admin_8009.entity.Order_Boom;
import com.bittereggs.admin_8009.mapper.OrderBoomMapper;
import com.bittereggs.admin_8009.service.OrderBoomService;
import com.bittereggs.admin_8009.util.JsonDateValueProcessor;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderBoomServiceImpl implements OrderBoomService {

    @Autowired
    private OrderBoomMapper orderBoomMapper;


    @Override
    public String getOrderBoom(Order_Boom orderboom) {
        JSONArray jsonArray;
        List<Order_Boom> list = orderBoomMapper.getOrderBoom(orderboom);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray.toString();
    }

    @Override
    public String addOrderBoom(Order_Boom orderboom) {
        JSONObject jsonObject = new JSONObject();
        try {
            orderBoomMapper.addOrderBoom(orderboom);
            jsonObject.put("msg","success");
        }catch(Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }

    @Override
    public String upOrderBoom(String orderid,String status) {
        JSONObject jsonObject=new JSONObject();

        orderBoomMapper.upOrderBoom(orderid,status);
        jsonObject.put("msg","success");

        return jsonObject.toString();
    }
}
