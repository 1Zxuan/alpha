package com.bittereggs.login_8001.mapper;

import com.bittereggs.login_8001.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "LoginMappper")
public interface LoginMapper {

    //注册
    void add(User user);

    void addworkroominfo(String username);

    void addenterpriseinfo(String username);

    void resetpassword(User user);

    User findByphone(String phone);

    User findByName(String name);


}
