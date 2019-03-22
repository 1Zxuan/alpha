package com.alpha.findinfromatin_8003.entity;

import java.io.Serializable;
import java.util.Date;

//招标书
public class BiddingBook implements Serializable {
    private Integer id;
    private String company_name;
    private Date release_time;
    private Date engineer_time;
    private Double project_amount;
    private String project_info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public Date getEngineer_time() {
        return engineer_time;
    }

    public void setEngineer_time(Date engineer_time) {
        this.engineer_time = engineer_time;
    }

    public Double getProject_amount() {
        return project_amount;
    }

    public void setProject_amount(Double project_amount) {
        this.project_amount = project_amount;
    }

    public String getProject_info() {
        return project_info;
    }

    public void setProject_info(String project_info) {
        this.project_info = project_info;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                ", release_time=" + release_time +
                ", engineer_time=" + engineer_time +
                ", project_amount=" + project_amount +
                ", project_info='" + project_info + '\'' +
                '}';
    }
}
