package com.bittereggs.login_8001.service;

import com.bittereggs.login_8001.entity.User;

public interface LoginService {

    void add(User user);

    boolean login(User user);

    boolean   adminlogin(User user);
}
