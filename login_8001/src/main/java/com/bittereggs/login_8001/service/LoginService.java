package com.bittereggs.login_8001.service;

import com.bittereggs.login_8001.entity.Admin;
import com.bittereggs.login_8001.entity.User;

public interface LoginService {

    Boolean add(User user);

    User findByName(String name);

    String getuserinfo(String username);

    String phonelogin(String phone, String yzm);

    String getyzm(String username ,String email);

    String getphoneloginyzm(String phone);

    Boolean checkyzm(String username, String yzm);

    Boolean resetpassword(User user);

    String adminlogin(Admin admin);

    String registeryzm(String phone);

    Boolean checkregisteryzm(String phone,String yzm);

    String checkusername(String username);
}
