package com.alpha.findinfromatin_8003.service;

import com.alpha.findinfromatin_8003.entity.BiddingBook;
import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.User;
import com.alpha.findinfromatin_8003.entity.WorkRoom;

import java.util.List;

public interface FindInfomationService {

    /*List<BiddingBook> getAllBiddingBook(String page, String order);*/

   /* List<BiddingBook> getBeforBiddingbook(String company_username);*/



    String getAllWorkRoom(String page);

    String searchWorkRoom(String key);

    String getWorkRoom(String workroom_username);

    String getEnterprise(String company_username);

    String getUserInfo(String username);
}
