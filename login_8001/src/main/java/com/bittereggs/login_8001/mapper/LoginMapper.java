package com.bittereggs.login_8001.mapper;

import com.bittereggs.login_8001.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    //注册
    void add(User user);

    void addworkroominfo(String username);

    void addenterpriseinfo(String username);

    void resetpassword(User user);

    User findById(Integer id);

    User findByName(String name);


}
