package com.bittereggs.attention_8006.entity;

import java.util.Date;

/**
 * @author 楼中煊
 * @data 2019/3/23
 * @time 23:00
 */
public class Attention {

    private Integer id;

    private String company;

    private String workroom;

    private Date attention_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorkroom() {
        return workroom;
    }

    public void setWorkroom(String workroom) {
        this.workroom = workroom;
    }

    public Date getAttention_date() {
        return attention_date;
    }

    public void setAttention_date(Date attention_date) {
        this.attention_date = attention_date;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", workroom='" + workroom + '\'' +
                ", attention_date=" + attention_date +
                '}';
    }
}
