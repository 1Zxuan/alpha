package com.alpha.findinfromatin_8003.service.impl;

import com.alpha.findinfromatin_8003.entity.BiddingBook;
import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.User;
import com.alpha.findinfromatin_8003.entity.WorkRoom;
import com.alpha.findinfromatin_8003.mapper.FindInformationMapper;
import com.alpha.findinfromatin_8003.service.FindInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FindInformationServiceImpl implements FindInfomationService {

    @Autowired
    private FindInformationMapper findInformationMapper;

    @Override
    public List<Enterprise> getBeforBiddingbook(String company_username) {

        return findInformationMapper.getBeforBiddingbook(company_username);
    }


    @Override
    public List<BiddingBook> getAllBiddingBook(String page,String order) {
        int p;
        if(Integer.parseInt(page) >=1 ){
            p = Integer.parseInt(page)*10+1;
        }else{
            p=0;
        }
        return findInformationMapper.getAllBiddingBook(p,order);
    }


    @Override
    public List<WorkRoom> getAllWorkRoom(String page) {
        int p;
        if(Integer.parseInt(page) >=1 ){
            p = Integer.parseInt(page)*10+1;
        }else{
            p=0;
        }
        return findInformationMapper.getAllWorkRoom(p);
    }

    @Override
    public List<WorkRoom> searchWorkRoom(String key) {
        return findInformationMapper.searchWorkRoom(key);
    }

    @Override
    public WorkRoom getWorkRoom(String workroom_username) {
        return findInformationMapper.getWorkRoom(workroom_username);
    }

    @Override
    public Enterprise getEnterprise(String company_username) {
        return findInformationMapper.getEnterprise(company_username);
    }

    @Override
    public User getUserInfo(String username) {
            return findInformationMapper.getUserInfo(username);
        }

}

