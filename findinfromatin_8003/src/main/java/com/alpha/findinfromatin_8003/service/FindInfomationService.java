package com.alpha.findinfromatin_8003.service;

import com.alpha.findinfromatin_8003.entity.BiddingBook;
import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.User;
import com.alpha.findinfromatin_8003.entity.WorkRoom;

import java.util.List;

public interface FindInfomationService {

    List<BiddingBook> getAllBiddingBook(String page, String order);

    List<Enterprise> getBeforBiddingbook(String company_username);



    List<WorkRoom> getAllWorkRoom(String page);

    List<WorkRoom> searchWorkRoom(String key);

    WorkRoom getWorkRoom(String workroom_username);

    Enterprise getEnterprise(String company_username);

    User getUserInfo(String username);
}
