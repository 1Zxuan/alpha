package com.bittereggs.login_8001.service;

import com.bittereggs.login_8001.entity.User;

public interface LoginService {

    Boolean add(User user);

    User findByName(String name);
}
