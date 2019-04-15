package com.bittereggs.admin_8009.service;

import com.bittereggs.admin_8009.entity.Order_Boom;

public interface OrderBoomService {

    String getOrderBoom(Order_Boom orderboom);

    String addOrderBoom(Order_Boom orderboom);

    String upOrderBoom(String orderid,String status);
}
