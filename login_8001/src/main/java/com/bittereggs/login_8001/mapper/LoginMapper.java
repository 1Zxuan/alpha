package com.bittereggs.login_8001.mapper;

import com.bittereggs.login_8001.entity.Admin;
import com.bittereggs.login_8001.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "LoginMappper")
public interface LoginMapper {

    //注册
    void add(User user);

    void addworkroominfo(String username);

    void addenterpriseinfo(String username);

    void resetpassword(User user);

    void setpaypassword(@Param("username") String username, @Param("paypassword")String paypassword);

    User findByphone(String phone);

    User findByName(String name);

    Admin adminlogin(Admin admin);

    Boolean checkphonlogin(String phone);

}
