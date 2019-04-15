package com.bittereggs.admin_8009.controller;

import com.bittereggs.admin_8009.entity.Order_Boom;
import com.bittereggs.admin_8009.service.OrderBoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderBoomController {

    @Autowired
    private OrderBoomService orderBoomService;

    @GetMapping("/getorderboom")
    public String getOrderBoom(@RequestBody Order_Boom orderboom){
        String res = orderBoomService.getOrderBoom(orderboom);
        return res;

    }

    @PostMapping("/addorderboom")
    public String addOrderBoom(@RequestBody Order_Boom orderboom){
        String res = orderBoomService.addOrderBoom(orderboom);
        return res;
    }

    @GetMapping("/uporderboom")
    public String upOrderBoom(@RequestParam("orderid") String orderid,@RequestParam("status") String status){
        String res = orderBoomService.upOrderBoom(orderid,status);
        return res;
    }
}
