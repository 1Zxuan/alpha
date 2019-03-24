package com.alpha.fillinformation_8004.service.impl;

import com.alpha.fillinformation_8004.entity.Enterprise;
import com.alpha.fillinformation_8004.entity.WorkRoom;
import com.alpha.fillinformation_8004.mapper.fillInformationMapper;
import com.alpha.fillinformation_8004.service.fillInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FillInformationServiceImpl implements fillInformationService {
    @Autowired
    private fillInformationMapper fillInformationMapper;

    public Boolean isfindenterpriseusername(String company_username){
        //System.out.println(fillInformationMapper.findenterpriseusername(company_username));
        return fillInformationMapper.findenterpriseusername(company_username);
    }
    public Boolean isfindworkroomusername(String workroom_username){
        //System.out.println(fillInformationMapper.findworkroomusername(workroom_username));
        return fillInformationMapper.findworkroomusername(workroom_username);
    }
    @Override
    public String fillenterprise(Enterprise enterprise) {
        System.out.println(enterprise.getId_card());
        try{
            if(!isfindenterpriseusername(enterprise.getCompany_username())){
                System.out.println("charu");
                fillInformationMapper.fillenterprise(enterprise);
            }
            else{
                System.out.println("genggai");
                fillInformationMapper.upfillenterprise(enterprise);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
           return "false";
        }
        return "true";
    }

    @Override
    public String fillworkroom(WorkRoom workRoom) {
        try{
            if(!isfindworkroomusername(workRoom.getWorkroom_username())){
                System.out.println("charu");
                fillInformationMapper.fillworkroom(workRoom);
            }
            else{
                System.out.println("genggai");
                fillInformationMapper.upfillworkroom(workRoom);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "false";
        }
        return "true";
    }
}
