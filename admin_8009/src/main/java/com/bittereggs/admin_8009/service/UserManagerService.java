package com.bittereggs.admin_8009.service;

import com.bittereggs.admin_8009.entity.User;

public interface UserManagerService {
    String getUser();

    String upUser(User user);

    String delUser(String username);
}
