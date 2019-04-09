package com.bittereggs.admin_8009.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Order_Boom {

    private Integer ID;

    private String orderid;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

    private Integer type;

    private Integer status;

    private String interrupt_content;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInterrupt_content() {
        return interrupt_content;
    }

    public void setInterrupt_content(String interrupt_content) {
        this.interrupt_content = interrupt_content;
    }

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", orderid='" + orderid + '\'' +
                ", time=" + time +
                ", type=" + type +
                ", status=" + status +
                ", interrupt_content='" + interrupt_content + '\'' +
                '}';
    }
}
