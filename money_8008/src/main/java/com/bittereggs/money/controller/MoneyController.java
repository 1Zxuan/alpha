package com.bittereggs.money.controller;

import com.bittereggs.money.entity.Transaction;
import com.bittereggs.money.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 楼中煊
 * @data 2019/3/30
 * @time 16:50
 */

@RestController
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    //充值
    @PostMapping("/recharge")
    public String recharge(@RequestBody Transaction transaction){
        return moneyService.recharge(transaction);
    }

    //提现
    @GetMapping("/withdraw")
    public String withdraw(@RequestBody Transaction transaction){
        return moneyService.withdraw(transaction);
    }

    //交易
    @PostMapping("/companypay")
    public String companypay(@RequestBody Transaction transaction){
        return moneyService.companypay(transaction);
    }

    @PostMapping("/workroomreceipt")
    public String workroomreceipt(@RequestBody Transaction transaction){
        return moneyService.workroomreceipt(transaction);
    }

}
