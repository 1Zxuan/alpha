package com.alpha.fillinformation_8004.entity;


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
    private String registered_date;
    private Integer status;
    private String volume;
    private String telphone;
    private String name;
    private String id_card;
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

    public String getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(String registered_date) {
        this.registered_date = registered_date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
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
        return "{" +
                "workroom_username='" + workroom_username + '\'' +
                ", workroom_name='" + workroom_name + '\'' +
                ", workroom_phone='" + workroom_phone + '\'' +
                ", team_honors='" + team_honors + '\'' +
                ", goodfield='" + goodfield + '\'' +
                ", score=" + score +
                ", registered_date='" + registered_date + '\'' +
                ", status=" + status +
                ", volume='" + volume + '\'' +
                ", telphone='" + telphone + '\'' +
                ", name='" + name + '\'' +
                ", id_card='" + id_card + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", moblephone='" + moblephone + '\'' +
                '}';
    }
}

