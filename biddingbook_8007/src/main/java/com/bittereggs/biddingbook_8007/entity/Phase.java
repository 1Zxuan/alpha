package com.bittereggs.biddingbook_8007.entity;

public class Phase {
    private String biddingbookid;

    private String workroomusername;

    private String phase_name;//拆

    private String deposit;//拆

    private String document;//拆

    private String finish;//拆

    private String picture;//拆

    private String pay_state;//拆

    private String order_id;

    private String enterprise_username;

    private String project_price;

    private String phase_price;//拆

    public Phase(String biddingbookid, String workroomusername, String phase_name, String deposit, String document, String finish, String picture, String pay_state, String order_id, String enterprise_username, String project_price, String phase_price) {
        this.biddingbookid = biddingbookid;
        this.workroomusername = workroomusername;
        this.phase_name = phase_name;
        this.deposit = deposit;
        this.document = document;
        this.finish = finish;
        this.picture = picture;
        this.pay_state = pay_state;
        this.order_id = order_id;
        this.enterprise_username = enterprise_username;
        this.project_price = project_price;
        this.phase_price = phase_price;
    }

    public String getPay_state() {
        return pay_state;
    }

    public void setPay_state(String pay_state) {
        this.pay_state = pay_state;
    }

    public String getBiddingbookid() {
        return biddingbookid;
    }

    public void setBiddingbookid(String biddingbookid) {
        this.biddingbookid = biddingbookid;
    }

    public String getWorkroomusername() {
        return workroomusername;
    }

    public void setWorkroomusername(String workroomusername) {
        this.workroomusername = workroomusername;
    }

    public String getPhase_name() {
        return phase_name;
    }

    public void setPhase_name(String phase_name) {
        this.phase_name = phase_name;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getEnterprise_username() {
        return enterprise_username;
    }

    public void setEnterprise_username(String enterprise_username) {
        this.enterprise_username = enterprise_username;
    }

    public String getProject_price() {
        return project_price;
    }

    public void setProject_price(String project_price) {
        this.project_price = project_price;
    }

    public String getPhase_price() {
        return phase_price;
    }

    public void setPhase_price(String phase_price) {
        this.phase_price = phase_price;
    }

    @Override
    public String toString() {
        return "{" +
                "biddingbookid='" + biddingbookid + '\'' +
                ", workroomusername='" + workroomusername + '\'' +
                ", phase_name='" + phase_name + '\'' +
                ", deposit='" + deposit + '\'' +
                ", document='" + document + '\'' +
                ", finish='" + finish + '\'' +
                ", picture='" + picture + '\'' +
                ", pay_state='" + pay_state + '\'' +
                ", order_id='" + order_id + '\'' +
                ", enterprise_username='" + enterprise_username + '\'' +
                ", project_price='" + project_price + '\'' +
                ", phase_price='" + phase_price + '\'' +
                '}';
    }
}
