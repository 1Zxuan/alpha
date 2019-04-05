package com.bittereggs.admin1_8010.service.impl;

import com.bittereggs.admin1_8010.entity.Money;
import com.bittereggs.admin1_8010.entity.Order;
import com.bittereggs.admin1_8010.mapper.AdminMapper;
import com.bittereggs.admin1_8010.service.AdminService;
import com.bittereggs.admin1_8010.utils.FormatData;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 楼中煊
 * @data 2019/4/5
 * @time 16:13
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String order() {
        FormatData formatData = new FormatData();
        ArrayList<Order> orders = adminMapper.order();
        JSONArray data = JSONArray.fromObject(orders);
        return formatData.formatorder(data);
    }

    @Override
    public String agree(Order orde) {
        FormatData formatData = new FormatData();
        //查询出数据库的数据
        Order database = adminMapper.selectbyorder_id(orde.getOrder_id());
        Order order = formatData.remakeOrder(database,orde);
        //admin少钱，工作室多钱
//        Money admin =
//                new Money("admin",Double.valueOf(orde.getPhase_price()),"-" + orde.getPhase_price(),3);
        //查询工作室名
        String username = adminMapper.workroom_name(orde.getEnterprise_name());

//        Money user =
//                new Money(username,Double.valueOf(orde.getPhase_price()),"+" + orde.getPhase_price(),2);
//        adminMapper.addmoney(admin);
//        adminMapper.addmoney(user);
        //更新数据库数据
        adminMapper.agree(order);
        adminMapper.addmoney(username,"admin", Double.valueOf(orde.getPhase_price()));
        return null;
    }
}
