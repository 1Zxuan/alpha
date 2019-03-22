package com.bittereggs.login_8001.entity;

/**
 * @author 楼中煊
 * @data 2019/3/19
 * @time 14:17
 */
public class WxUser {

    private Integer id;

    private String openid;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
