package com.bittereggs.login_8001.service;

import com.bittereggs.login_8001.entity.User;

public interface LoginService {

    void add(User user);

    Boolean login(User user);

    Boolean   adminlogin(User user);
}
