package com.bittereggs.biddingbook_8007.entity;

import java.io.Serializable;

public class Invatation implements Serializable {
    private Integer ID;

    private String biddingbookid;

    private String postscript;

    private String company_username;

    private String workroom_username;

    private int agree;

    public String getCompany_username() {
        return company_username;
    }

    public void setCompany_username(String company_username) {
        this.company_username = company_username;
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

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }

    public String getWorkroom_username() {
        return workroom_username;
    }

    public void setWorkroom_username(String workroom_username) {
        this.workroom_username = workroom_username;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", biddingbookid='" + biddingbookid + '\'' +
                ", postscript='" + postscript + '\'' +
                ", company_username='" + company_username + '\'' +
                ", workroom_username='" + workroom_username + '\'' +
                ", agree=" + agree +
                '}';
    }
}
