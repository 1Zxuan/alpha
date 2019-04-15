package com.bittereggs.login_8001.entity;

/**
 * @author 楼中煊
 * @data 2019/3/19
 * @time 14:17
 */
public class WxUser {

    private Integer id;

    private String openid;

    private String cellphone;

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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String username) {
        this.cellphone = username;
    }

    public WxUser() {
    }

    public WxUser(String openid, String cellphone) {
        this.openid = openid;
        this.cellphone = cellphone;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
