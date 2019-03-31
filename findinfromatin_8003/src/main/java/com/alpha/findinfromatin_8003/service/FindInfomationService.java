package com.alpha.findinfromatin_8003.service;



public interface FindInfomationService {

    String getAllWorkRoom(String page);

    String searchWorkRoom(String key);

    String getWorkRoom(String workroom_username);

    String getEnterprise(String company_username);
}
