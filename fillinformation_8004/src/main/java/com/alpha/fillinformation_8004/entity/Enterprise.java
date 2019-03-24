package com.alpha.fillinformation_8004.entity;

import java.io.Serializable;

public class Enterprise implements Serializable {
    private String company_username;
    private String company_name;
    private String company_Mobile;
    private String company_info;
    private String company_logo;
    private String company_address;
    private String company_locale;
    private String service_industry;
    private Float graded;
    private String registration_date;
    private int status;
    private int volume;
    private String telphone;
    private String name;
    private String id_card;
    private String address;
    private String email;
    private String mobilephone;

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

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
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

    public Float getGraded() {
        return graded;
    }

    public void setGraded(Float graded) {
        this.graded = graded;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
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

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    @Override
    public String toString() {
        return "{" +
                "company_username='" + company_username + '\'' +
                ", company_name='" + company_name + '\'' +
                ", company_Mobile='" + company_Mobile + '\'' +
                ", company_info='" + company_info + '\'' +
                ", company_logo='" + company_logo + '\'' +
                ", company_address='" + company_address + '\'' +
                ", company_locale='" + company_locale + '\'' +
                ", service_industry='" + service_industry + '\'' +
                ", graded=" + graded +
                ", registration_date=" + registration_date +
                ", status=" + status +
                ", volume=" + volume +
                ", telphone='" + telphone + '\'' +
                ", name='" + name + '\'' +
                ", id_card='" + id_card + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                '}';
    }
}
