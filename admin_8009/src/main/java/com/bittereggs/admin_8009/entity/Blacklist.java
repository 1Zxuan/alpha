package com.bittereggs.admin_8009.entity;

import java.util.Date;

public class Blacklist {

    String name;

    Date time;

    String reason;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", reason='" + reason + '\'' +
                '}';
    }
}
