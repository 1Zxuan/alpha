package com.bittereggs.admin1_8010.entity;

/**
 * @author 楼中煊
 * @data 2019/4/5
 * @time 16:17
 */
public class Order {

    private String order_id;

    private String phase_name;

    private String enterprise_name;

    private String phase_price;

    private String pay_state;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPhase_name() {
        return phase_name;
    }

    public void setPhase_name(String phase_name) {
        this.phase_name = phase_name;
    }

    public String getEnterprise_name() {
        return enterprise_name;
    }

    public void setEnterprise_name(String enterprise_name) {
        this.enterprise_name = enterprise_name;
    }

    public String getPhase_price() {
        return phase_price;
    }

    public void setPhase_price(String phase_price) {
        this.phase_price = phase_price;
    }

    public String getPay_state() {
        return pay_state;
    }

    public void setPay_state(String pay_state) {
        this.pay_state = pay_state;
    }

    public Order(String order_id, String phase_name, String enterprise_name, String phase_price, String pay_state) {
        this.order_id = order_id;
        this.phase_name = phase_name;
        this.enterprise_name = enterprise_name;
        this.phase_price = phase_price;
        this.pay_state = pay_state;
    }

    public Order(){}

    @Override
    public String toString() {
        return "{" +
                "order_id='" + order_id + '\'' +
                ", phase_name='" + phase_name + '\'' +
                ", enterprise_name='" + enterprise_name + '\'' +
                ", phase_price='" + phase_price + '\'' +
                ", pay_state='" + pay_state + '\'' +
                '}';
    }

}
