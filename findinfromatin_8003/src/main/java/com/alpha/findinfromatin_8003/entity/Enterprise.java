package com.alpha.findinfromatin_8003.entity;

import java.io.Serializable;
import java.util.Date;

public class Enterprise implements Serializable {
    private String company_username;
    private String company_name;
    private String company_Mobile;
    private String company_info;
    private String company_address;
    private String company_locale;
    private String service_industry;
    private double graded;
    private int volume;
    private String name;
    private String address;
    private String email;
    private String cellphone;
    private String headimage;
    private Date registertime;

    @Override
    public String toString() {
        return "{" +
                "company_username='" + company_username + '\'' +
                ", company_name='" + company_name + '\'' +
                ", company_Mobile='" + company_Mobile + '\'' +
                ", company_info='" + company_info + '\'' +
                ", company_address='" + company_address + '\'' +
                ", company_locale='" + company_locale + '\'' +
                ", service_industry='" + service_industry + '\'' +
                ", graded=" + graded +
                ", volume=" + volume +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", headimage='" + headimage + '\'' +
                ", registertime=" + registertime +
                '}';
    }

    public String getCompany_username() {
        return company_username;
    }

    public void setCompany_username(String company_username) {
        this.company_username = company_username;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_Mobile() {
        return company_Mobile;
    }

    public void setCompany_Mobile(String company_Mobile) {
        this.company_Mobile = company_Mobile;
    }

    public String getCompany_info() {
        return company_info;
    }

    public void setCompany_info(String company_info) {
        this.company_info = company_info;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getCompany_locale() {
        return company_locale;
    }

    public void setCompany_locale(String company_locale) {
        this.company_locale = company_locale;
    }

    public String getService_industry() {
        return service_industry;
    }

    public void setService_industry(String service_industry) {
        this.service_industry = service_industry;
    }

    public double getGraded() {
        return graded;
    }

    public void setGraded(double graded) {
        this.graded = graded;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
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
