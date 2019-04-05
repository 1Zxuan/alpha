package com.bittereggs.admin_8009.service;

import com.bittereggs.admin_8009.entity.Blacklist;

public interface BlacklistService {

    String getBlackList(Blacklist blacklist);

    String addBlackList(Blacklist blacklist);

    String delBlackList(String name);

}
