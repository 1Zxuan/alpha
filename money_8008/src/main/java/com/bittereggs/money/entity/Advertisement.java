package com.bittereggs.money.entity;

import java.util.Date;

/**
 * @author 楼中煊
 * @data 2019/4/1
 * @time 19:37
 */
public class Advertisement {
    private Integer ID;

    private String username;

    private Date start_time;

    private Date end_time;

    private String image_path;

    private String link;

    private Integer state;

    private Integer type;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", image_path='" + image_path + '\'' +
                ", link='" + link + '\'' +
                ", state=" + state +
                ", type=" + type +
                '}';
    }
}
