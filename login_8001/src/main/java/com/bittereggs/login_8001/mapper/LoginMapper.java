package com.bittereggs.login_8001.mapper;

import com.bittereggs.login_8001.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    void add(User user);

    boolean login(User user);

    boolean   adminlogin(User user);
}
