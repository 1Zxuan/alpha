package com.bittereggs.biddingbook_8007.entity;

import java.io.Serializable;

public class Tender_info implements Serializable {
    private Integer ID;

    private String biddingbookid;

    private String company_username;

    private String workroom_username;

    private String state;

    private String tender_price;

    private String headimage;

    private Integer score;

    private Integer volume;


    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
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

    public String getWorkroom_username() {
        return workroom_username;
    }

    public void setWorkroom_username(String workroom_username) {
        this.workroom_username = workroom_username;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTender_price() {
        return tender_price;
    }

    public void setTender_price(String tender_price) {
        this.tender_price = tender_price;
    }

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", biddingbookid='" + biddingbookid + '\'' +
                ", company_username='" + company_username + '\'' +
                ", workroom_username='" + workroom_username + '\'' +
                ", state='" + state + '\'' +
                ", tender_price='" + tender_price + '\'' +
                ", headimage='" + headimage + '\'' +
                ", score=" + score +
                ", volume=" + volume +
                '}';
    }
}
