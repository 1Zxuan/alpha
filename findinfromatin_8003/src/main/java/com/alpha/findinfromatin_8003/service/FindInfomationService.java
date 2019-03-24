package com.alpha.findinfromatin_8003.service;

import com.alpha.findinfromatin_8003.entity.BiddingBook;
import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.WorkRoom;

import java.util.List;

public interface FindInfomationService {
    WorkRoom getWorkRoom(String workroom_username);

    BiddingBook getBiddingBook(String bidding_name);

    List<WorkRoom> getAllWorkRoom(String page);

    List<WorkRoom> searchWorkRoom(String key);

    List<BiddingBook> getAllBiddingBook(String page,String order);

    Enterprise getEnterprise(String company_username);
}
