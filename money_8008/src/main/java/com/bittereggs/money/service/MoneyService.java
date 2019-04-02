package com.bittereggs.money.service;

import com.bittereggs.money.entity.Transaction;

/**
 * @author 楼中煊
 * @data 2019/3/30
 * @time 16:53
 */


public interface MoneyService {

    String recharge(Transaction transaction);

    String withdraw(Transaction transaction);

    String companypay(Transaction transaction);

    String workroomreceipt(Transaction transaction);
}
