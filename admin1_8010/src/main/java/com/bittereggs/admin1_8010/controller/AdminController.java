package com.bittereggs.admin1_8010.controller;

import com.bittereggs.admin1_8010.entity.Order;
import com.bittereggs.admin1_8010.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 楼中煊
 * @data 2019/4/5
 * @time 15:57
 */

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    //显示所有订单数据
    @GetMapping("/order")
    public String order(){
        return adminService.order();
    }

    //同意&转账
    @PostMapping("/agree")
    public String agree(@RequestBody Order order){
        System.out.println(order.toString());
        return adminService.agree(order);
    }
}
