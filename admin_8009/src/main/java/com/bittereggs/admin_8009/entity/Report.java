package com.bittereggs.admin_8009.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Report implements Serializable {

    private Integer ID;

    private String complain_username;

    private String respond_username;

    private String complain_type;

    private String complain_content;

    private Integer complain_status;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date complain_time;

    private Integer complain_res;

    public Integer getComplain_res() {
        return complain_res;
    }

    public void setComplain_res(Integer complain_res) {
        this.complain_res = complain_res;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getComplain_username() {
        return complain_username;
    }

    public void setComplain_username(String complain_username) {
        this.complain_username = complain_username;
    }

    public String getRespond_username() {
        return respond_username;
    }

    public void setRespond_username(String respond_username) {
        this.respond_username = respond_username;
    }

    public String getComplain_type() {
        return complain_type;
    }

    public void setComplain_type(String complain_type) {
        this.complain_type = complain_type;
    }

    public String getComplain_content() {
        return complain_content;
    }

    public void setComplain_content(String complain_content) {
        this.complain_content = complain_content;
    }

    public Integer getComplain_status() {
        return complain_status;
    }

    public void setComplain_status(Integer complain_status) {
        this.complain_status = complain_status;
    }

    public Date getComplain_time() {
        return complain_time;
    }

    public void setComplain_time(Date complain_time) {
        this.complain_time = complain_time;
    }

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", complain_username='" + complain_username + '\'' +
                ", respond_username='" + respond_username + '\'' +
                ", complain_type='" + complain_type + '\'' +
                ", complain_content='" + complain_content + '\'' +
                ", complain_status=" + complain_status +
                ", complain_time=" + complain_time +
                ", complain_res=" + complain_res +
                '}';
    }
}
