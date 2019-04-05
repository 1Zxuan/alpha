package com.bittereggs.admin1_8010.entity;

import java.util.Date;

/**
 * @author 楼中煊
 * @data 2019/4/5
 * @time 20:40
 */
public class Money {

    private Integer ID;

    private String username;

    private Double balance;

    private String inoutmoney;

    private Date tradingtime;

    private Integer transaction_type;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getInoutmoney() {
        return inoutmoney;
    }

    public void setInoutmoney(String inoutmoney) {
        this.inoutmoney = inoutmoney;
    }

    public Date getTradingtime() {
        return tradingtime;
    }

    public void setTradingtime(Date tradingtime) {
        this.tradingtime = tradingtime;
    }

    public Integer getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(Integer transaction_type) {
        this.transaction_type = transaction_type;
    }

    public Money(String username, Double balance, String inoutmoney, Integer transaction_type) {
        this.username = username;
        this.balance = balance;
        this.inoutmoney = inoutmoney;
        this.transaction_type = transaction_type;
    }

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                ", inoutmoney='" + inoutmoney + '\'' +
                ", tradingtime=" + tradingtime +
                ", transaction_type=" + transaction_type +
                '}';
    }
}
