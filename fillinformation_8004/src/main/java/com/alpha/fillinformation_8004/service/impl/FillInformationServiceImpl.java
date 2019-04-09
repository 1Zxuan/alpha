package com.alpha.fillinformation_8004.service.impl;

import com.alpha.fillinformation_8004.config.RedisHelper;
import com.alpha.fillinformation_8004.entity.*;
import com.alpha.fillinformation_8004.mapper.fillInformationMapper;
import com.alpha.fillinformation_8004.service.fillInformationService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FillInformationServiceImpl implements fillInformationService {

    @Autowired
    private RedisHelper redisHelper;

    @Autowired
    private fillInformationMapper fillInformationMapper;

    //    是否存在企业
    public Boolean isfindenterpriseusername(String company_username) {
        return fillInformationMapper.findenterpriseusername(company_username);
    }

    //    是否存在工作室
    public Boolean isfindworkroomusername(String workroom_username, String tables) {
        return fillInformationMapper.findworkroomusername(workroom_username, tables);
    }

    //    往企业审核表插入企业审核
    @Override
    public String fillEnterpriseAuditing(Enterprise_info_auditing enterpriseinfoauditing) {
        JSONObject jsonObject = new JSONObject();
        try {

            //判断是否存在
            if (!isfindenterpriseusername(enterpriseinfoauditing.getCompany_username())) {
                fillInformationMapper.fillEnterpriseAuditing(enterpriseinfoauditing);
            } else {
                fillInformationMapper.upEnterpriseAuditing(enterpriseinfoauditing);
            }
        } catch (Exception e) {
            jsonObject.put("msg", "false");
            return jsonObject.toString();
        }
        jsonObject.put("msg", "true");
        return jsonObject.toString();
    }

    //    往工作室审核表插入工作室审核
    @Override
    public String fillWorkroomAuditing(WorkRoom_info_auditing workRoomInfoauditing) {
        JSONObject jsonObject = new JSONObject();
        try {
            //判断是否已经存在
            if (!isfindworkroomusername(workRoomInfoauditing.getWorkroom_username(), "workroom_info_auditing")) {
                fillInformationMapper.fillWorkroomAuditing(workRoomInfoauditing);
            } else {
                fillInformationMapper.upWorkroomAuditing(workRoomInfoauditing);
            }
        } catch (Exception e) {
            jsonObject.put("msg", "false");
            return jsonObject.toString();
        }
        jsonObject.put("msg", "true");
        return jsonObject.toString();
    }

    //更新基本信息
    @Override
    public String upUserInfo(User user) {
        JSONObject jsonObject = new JSONObject();
        GoodField goodField = new GoodField();
        try {
        if (!isfindworkroomusername(user.getUsername(), "workroom_goodfield")) {
            fillInformationMapper.addWorkroomGoodField(user.getUsername());
        }
        String[] str;
        String goodfeild = user.getGoodfield();
        if (goodfeild != null) {
            str = goodfeild.split("/");
            goodField.setWorkroom_username(user.getUsername());
            for (int i = 0; i < str.length; i++) {
                switch (str[i]) {
                    case "website_build":
                        goodField.setWebsite_build(1);
                        break;
                    case "mobile_development":
                        goodField.setMobile_development(1);
                        break;
                    case "software_development":
                        goodField.setSoftware_development(1);
                        break;
                    case "product_UI_IT_solutions":
                        goodField.setProduct_UI_IT_solutions(1);
                        break;
                    case "saasServeice":
                        goodField.setSaasServeice(1);
                        break;
                    case "domain_name_cloud_services":
                        goodField.setDomain_name_cloud_services(1);
                        break;
                    case "data_services":
                        goodField.setData_services(1);
                        break;
                    case "testing_services":
                        goodField.setTesting_services(1);
                        break;
                }
            }
            fillInformationMapper.upAreasExpertise1(goodField);
        }

        //删除缓存中的信息
        redisHelper.hashRemove("UserList",user.getUsername());
        fillInformationMapper.upUserInfo(user);

        }catch(Exception e){
            jsonObject.put("msg","false");
            return jsonObject.toString();
        }
        jsonObject.put("msg", "true");
        return jsonObject.toString();
    }
}
