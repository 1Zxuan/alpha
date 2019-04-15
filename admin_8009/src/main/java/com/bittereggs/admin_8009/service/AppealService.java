package com.bittereggs.admin_8009.service;

import com.bittereggs.admin_8009.entity.Appeal;

public interface AppealService {

    String getAppeal(Appeal appeal);

    String addAppeal(Appeal appeal);

    String upAppeal(Appeal appeal);
}
