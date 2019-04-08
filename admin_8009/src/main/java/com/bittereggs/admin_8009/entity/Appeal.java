package com.bittereggs.admin_8009.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Appeal implements Serializable {

    private Integer ID;

    private String username;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date appeal_date;

    private Integer appeal_status;

    private Integer appeal_res;

    private String appeal_content;

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

    public Date getAppeal_date() {
        return appeal_date;
    }

    public void setAppeal_date(Date appeal_date) {
        this.appeal_date = appeal_date;
    }

    public Integer getAppeal_status() {
        return appeal_status;
    }

    public void setAppeal_status(Integer appeal_status) {
        this.appeal_status = appeal_status;
    }

    public Integer getAppeal_res() {
        return appeal_res;
    }

    public void setAppeal_res(Integer appeal_res) {
        this.appeal_res = appeal_res;
    }

    public String getAppeal_content() {
        return appeal_content;
    }

    public void setAppeal_content(String appeal_content) {
        this.appeal_content = appeal_content;
    }

    @Override
    public String toString() {
        return "Appeal{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", appeal_date=" + appeal_date +
                ", appeal_status=" + appeal_status +
                ", appeal_res=" + appeal_res +
                ", appeal_content='" + appeal_content + '\'' +
                '}';
    }
}
