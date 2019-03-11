package com.bittereggs.login_8001.service.impl;

import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.mapper.LoginMapper;
import com.bittereggs.login_8001.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public void add(User user) {

    }

    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean adminlogin(User user) {
        return false;
    }
}
