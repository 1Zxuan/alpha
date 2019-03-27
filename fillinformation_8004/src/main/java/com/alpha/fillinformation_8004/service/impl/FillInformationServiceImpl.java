package com.alpha.fillinformation_8004.service.impl;

import com.alpha.fillinformation_8004.entity.*;
import com.alpha.fillinformation_8004.mapper.fillInformationMapper;
import com.alpha.fillinformation_8004.service.fillInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FillInformationServiceImpl implements fillInformationService {
    @Autowired
    private fillInformationMapper fillInformationMapper;
    //    是否存在企业
    public Boolean isfindenterpriseusername(String company_username){
        return fillInformationMapper.findenterpriseusername(company_username);
    }
    //    是否存在工作室
    public Boolean isfindworkroomusername(String workroom_username){
        return fillInformationMapper.findworkroomusername(workroom_username);
    }
    //    往企业审核表插入企业审核
    @Override
    public String fillEnterpriseAuditing(Enterprise_info_auditing enterpriseinfoauditing) {
        try{
            //判断是否存在
            if(!isfindenterpriseusername(enterpriseinfoauditing.getCompany_username())){
                fillInformationMapper.fillEnterpriseAuditing(enterpriseinfoauditing);
            }
            else{
                fillInformationMapper.upEnterpriseAuditing(enterpriseinfoauditing);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "false";
        }
        return "true";
    }
    //    往工作室审核表插入工作室审核
    @Override
    public String fillWorkroomAuditing(WorkRoom_info_auditing workRoomInfoauditing) {
        try{
            //判断是否已经存在
            if(!isfindworkroomusername(workRoomInfoauditing.getWorkroom_username())){
                fillInformationMapper.fillWorkroomAuditing(workRoomInfoauditing);
            }
            else{
                fillInformationMapper.upWorkroomAuditing(workRoomInfoauditing);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "false";
        }
        return "true";
    }
    //更新基本信息
    @Override
    public String upUserInfo(User user) {
        try {
            fillInformationMapper.upUserInfo(user);

        }catch(Exception e){
            System.out.println(e);
            return "false";
        }
        return "true";
    }
}
