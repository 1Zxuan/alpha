package com.alpha.findinfromatin_8003.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

//工作室
public class WorkRoom implements Serializable {
    private String workroom_username;
    private String workroom_name;
    private String workroom_phone;
    private String team_honors;
    private String goodfield;
    private Float score;
    private Date registered_date;
    private Integer state;
    private String volume;
    private String telphone;
    private String name;
    private String ID_card;
    private String address;
    private String email;
    private String moblephone;

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

    public Date getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(Date registered_date) {
        this.registered_date = registered_date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID_card() {
        return ID_card;
    }

    public void setID_card(String ID_card) {
        this.ID_card = ID_card;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoblephone() {
        return moblephone;
    }

    public void setMoblephone(String moblephone) {
        this.moblephone = moblephone;
    }

    @Override
    public String toString() {
        return "WorkRoom{" +
                "workroom_username='" + workroom_username + '\'' +
                ", workroom_name='" + workroom_name + '\'' +
                ", workroom_phone='" + workroom_phone + '\'' +
                ", team_honors='" + team_honors + '\'' +
                ", goodfield='" + goodfield + '\'' +
                ", score=" + score +
                ", registered_date=" + registered_date +
                ", state=" + state +
                ", volume='" + volume + '\'' +
                ", telphone='" + telphone + '\'' +
                ", name='" + name + '\'' +
                ", ID_card='" + ID_card + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", moblephone='" + moblephone + '\'' +
                '}';
    }
}
