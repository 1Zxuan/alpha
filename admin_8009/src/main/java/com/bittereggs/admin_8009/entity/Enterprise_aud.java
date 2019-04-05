package com.bittereggs.admin_8009.entity;

import java.io.Serializable;

public class Enterprise_aud implements Serializable {

    private Integer ID;

    private String company_username;

    private String company_name;

    private String company_Mobile;

    private String company_info;

    private String company_address;

    private String company_locale;

    private String service_industry;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", company_username='" + company_username + '\'' +
                ", company_name='" + company_name + '\'' +
                ", company_Mobile='" + company_Mobile + '\'' +
                ", company_info='" + company_info + '\'' +
                ", company_address='" + company_address + '\'' +
                ", company_locale='" + company_locale + '\'' +
                ", service_industry='" + service_industry + '\'' +
                ", status=" + status +
                '}';
    }
}
