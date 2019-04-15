package com.bittereggs.admin_8009.mapper;

import com.bittereggs.admin_8009.entity.Order_Boom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "OrderBoomMapper")
public interface OrderBoomMapper {

    List<Order_Boom> getOrderBoom(Order_Boom orderboom);

    void addOrderBoom(Order_Boom orderboom);

    void upOrderBoom(String orderid,String status);
}
