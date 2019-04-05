package com.bittereggs.admin1_8010.mapper;

import com.bittereggs.admin1_8010.entity.Money;
import com.bittereggs.admin1_8010.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * @author 楼中煊
 * @data 2019/4/5
 * @time 16:14
 */

@Mapper
public interface AdminMapper {
    ArrayList<Order> order();

    void agree(Order order);

    Order selectbyorder_id(String order_id);

    String workroom_name(String enterprise_name);

    void addmoney(@Param("0")String workroom, @Param("1")String admin, @Param("2")Double balance);
}
