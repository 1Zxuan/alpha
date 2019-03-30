package com.bittereggs.biddingbook_8007.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BiddingBook implements Serializable {
    private Integer ID;

    private String biddingbookid;

    private String company_username;

    private String company_name;

    private String biddingbook;

    private String bidding_name;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date release_time;

    private String project_title;

    private String project_info;

    private double project_amount;

    private String project_type;

    private Integer engineer_time;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date project_endtime;

    private String domian;

    private String dev_platform;

    private String dev_language;

    private String database;

    private String demand;

    private String technology;

    private String feedbacktime;

    private Integer type;

    private String field;

    private String order;

    private Integer page;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getBiddingbookid() {
        return biddingbookid;
    }

    public void setBiddingbookid(String biddingbookid) {
        this.biddingbookid = biddingbookid;
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

    public String getBiddingbook() {
        return biddingbook;
    }

    public void setBiddingbook(String biddingbook) {
        this.biddingbook = biddingbook;
    }

    public String getBidding_name() {
        return bidding_name;
    }

    public void setBidding_name(String bidding_name) {
        this.bidding_name = bidding_name;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public String getProject_title() {
        return project_title;
    }

    public void setProject_title(String project_title) {
        this.project_title = project_title;
    }

    public String getProject_info() {
        return project_info;
    }

    public void setProject_info(String project_info) {
        this.project_info = project_info;
    }

    public double getProject_amount() {
        return project_amount;
    }

    public void setProject_amount(double project_amount) {
        this.project_amount = project_amount;
    }

    public String getProject_type() {
        return project_type;
    }

    public void setProject_type(String project_type) {
        this.project_type = project_type;
    }

    public Integer getEngineer_time() {
        return engineer_time;
    }

    public void setEngineer_time(Integer engineer_time) {
        this.engineer_time = engineer_time;
    }

    public Date getProject_endtime() {
        return project_endtime;
    }

    public void setProject_endtime(Date project_endtime) {
        this.project_endtime = project_endtime;
    }

    public String getDomian() {
        return domian;
    }

    public void setDomian(String domian) {
        this.domian = domian;
    }

    public String getDev_platform() {
        return dev_platform;
    }

    public void setDev_platform(String dev_platform) {
        this.dev_platform = dev_platform;
    }

    public String getDev_language() {
        return dev_language;
    }

    public void setDev_language(String dev_language) {
        this.dev_language = dev_language;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getFeedbacktime() {
        return feedbacktime;
    }

    public void setFeedbacktime(String feedbacktime) {
        this.feedbacktime = feedbacktime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", biddingbookid='" + biddingbookid + '\'' +
                ", company_username='" + company_username + '\'' +
                ", company_name='" + company_name + '\'' +
                ", biddingbook='" + biddingbook + '\'' +
                ", bidding_name='" + bidding_name + '\'' +
                ", release_time=" + release_time +
                ", project_title='" + project_title + '\'' +
                ", project_info='" + project_info + '\'' +
                ", project_amount=" + project_amount +
                ", project_type='" + project_type + '\'' +
                ", engineer_time=" + engineer_time +
                ", project_endtime=" + project_endtime +
                ", domian='" + domian + '\'' +
                ", dev_platform='" + dev_platform + '\'' +
                ", dev_language='" + dev_language + '\'' +
                ", database='" + database + '\'' +
                ", demand='" + demand + '\'' +
                ", technology='" + technology + '\'' +
                ", feedbacktime='" + feedbacktime + '\'' +
                ", type=" + type +
                ", field='" + field + '\'' +
                ", order='" + order + '\'' +
                ", page=" + page +
                '}';
    }
}
