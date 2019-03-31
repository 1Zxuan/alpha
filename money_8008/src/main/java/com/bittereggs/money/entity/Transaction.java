package com.bittereggs.money.entity;

/**
 * @author 楼中煊
 * @data 2019/3/31
 * @time 20:24
 */
public class Transaction {

    private String username;

    private String money;

    private String paypassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword;
    }

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", money='" + money + '\'' +
                ", paypassword='" + paypassword + '\'' +
                '}';
    }
}
