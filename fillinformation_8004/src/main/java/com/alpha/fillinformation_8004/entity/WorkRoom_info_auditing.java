package com.alpha.fillinformation_8004.entity;

import java.io.Serializable;

/**
 * @author 楼中煊
 * @data 2019/3/27
 * @time 20:21
 */
public class WorkRoom_info_auditing implements Serializable {

    private int ID;
    private String workroom_username;
    private String workroom_name;
    private String workroom_phone;
    private String team_honors;
    private Integer status;

    @Override
    public String toString() {
        return "{" +
                "ID=" + ID +
                ", workroom_username='" + workroom_username + '\'' +
                ", workroom_name='" + workroom_name + '\'' +
                ", workroom_phone='" + workroom_phone + '\'' +
                ", team_honors='" + team_honors + '\'' +
                ", status=" + status +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
