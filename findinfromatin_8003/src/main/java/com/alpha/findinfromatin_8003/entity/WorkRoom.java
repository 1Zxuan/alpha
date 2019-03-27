package com.alpha.findinfromatin_8003.entity;

import java.io.Serializable;
import java.util.Date;

//工作室
public class WorkRoom implements Serializable {
    private String workroom_username;
    private String workroom_name;
    private String workroom_phone;
    private String team_honors;
    private String goodfield;
    private Float score;
    private String volume;
    private String bigfield;
    private String cellphone;
    private String email;
    private String name;
    private String address;
    private String headimage;
    private Date registertime;

    @Override
    public String toString() {
        return "{" +
                "workroom_username='" + workroom_username + '\'' +
                ", workroom_name='" + workroom_name + '\'' +
                ", workroom_phone='" + workroom_phone + '\'' +
                ", team_honors='" + team_honors + '\'' +
                ", goodfield='" + goodfield + '\'' +
                ", score=" + score +
                ", volume='" + volume + '\'' +
                ", bigfield='" + bigfield + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", headimage='" + headimage + '\'' +
                ", registertime=" + registertime +
                '}';
    }

    public String getWorkroom_username() {
        return workroom_username;
    }

    public void setWorkroom_username(String workroom_username) {
        this.workroom_username = workroom_username;
    }

    public String getWorkroom_name() {
        return workroom_name;
    }

    public void setWorkroom_name(String workroom_name) {
        this.workroom_name = workroom_name;
    }

    public String getWorkroom_phone() {
        return workroom_phone;
    }

    public void setWorkroom_phone(String workroom_phone) {
        this.workroom_phone = workroom_phone;
    }

    public String getTeam_honors() {
        return team_honors;
    }

    public void setTeam_honors(String team_honors) {
        this.team_honors = team_honors;
    }

    public String getGoodfield() {
        return goodfield;
    }

    public void setGoodfield(String goodfield) {
        this.goodfield = goodfield;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getBigfield() {
        return bigfield;
    }

    public void setBigfield(String bigfield) {
        this.bigfield = bigfield;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }
}
