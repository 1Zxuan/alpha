package com.alpha.findinfromatin_8003.entity;

import java.io.Serializable;
import java.util.Date;

//工作室
public class WorkRoom implements Serializable {
    private String workroom_username;

    private String workroom_name;

    private String workroom_phone;

    private String team_honors;

    private Integer score;

    private Integer volume;

    private String areas_expertise;

    private String cellphone;

    private String email;

    private String name;

    private String address;

    private String headimage;

    private Date registertime;
    private Integer website_build;
    private Integer mobile_development;
    private Integer product_UI_IT_solutions;
    private Integer software_development;
    private Integer saasServeice;
    private Integer domain_name_cloud_services;
    private Integer data_services;
    private Integer testing_services;

    public Integer getWebsite_build() {
        return website_build;
    }

    public void setWebsite_build(Integer website_build) {
        this.website_build = website_build;
    }

    public Integer getMobile_development() {
        return mobile_development;
    }

    public void setMobile_development(Integer mobile_development) {
        this.mobile_development = mobile_development;
    }

    public Integer getProduct_UI_IT_solutions() {
        return product_UI_IT_solutions;
    }

    public void setProduct_UI_IT_solutions(Integer product_UI_IT_solutions) {
        this.product_UI_IT_solutions = product_UI_IT_solutions;
    }

    public Integer getSoftware_development() {
        return software_development;
    }

    public void setSoftware_development(Integer software_development) {
        this.software_development = software_development;
    }

    public Integer getSaasServeice() {
        return saasServeice;
    }

    public void setSaasServeice(Integer saasServeice) {
        this.saasServeice = saasServeice;
    }

    public Integer getDomain_name_cloud_services() {
        return domain_name_cloud_services;
    }

    public void setDomain_name_cloud_services(Integer domain_name_cloud_services) {
        this.domain_name_cloud_services = domain_name_cloud_services;
    }

    public Integer getData_services() {
        return data_services;
    }

    public void setData_services(Integer data_services) {
        this.data_services = data_services;
    }

    public Integer getTesting_services() {
        return testing_services;
    }

    public void setTesting_services(Integer testing_services) {
        this.testing_services = testing_services;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getAreas_expertise() {
        return areas_expertise;
    }

    public void setAreas_expertise(String areas_expertise) {
        this.areas_expertise = areas_expertise;
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

    @Override
    public String toString() {
        return "WorkRoom{" +
                "workroom_username='" + workroom_username + '\'' +
                ", workroom_name='" + workroom_name + '\'' +
                ", workroom_phone='" + workroom_phone + '\'' +
                ", team_honors='" + team_honors + '\'' +
                ", score=" + score +
                ", volume=" + volume +
                ", areas_expertise='" + areas_expertise + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", headimage='" + headimage + '\'' +
                ", registertime=" + registertime +
                ", website_build=" + website_build +
                ", mobile_development=" + mobile_development +
                ", product_UI_IT_solutions=" + product_UI_IT_solutions +
                ", software_development=" + software_development +
                ", saasServeice=" + saasServeice +
                ", domain_name_cloud_services=" + domain_name_cloud_services +
                ", data_services=" + data_services +
                ", testing_services=" + testing_services +
                '}';
    }
}
