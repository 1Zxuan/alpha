package com.alpha.fillinformation_8004.mapper;

import com.alpha.fillinformation_8004.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "fillInformationMapper")
public interface fillInformationMapper {

    Boolean findenterpriseusername(String company_username);

    Boolean findworkroomusername(String workroom_username);

    int upUserInfo(User user);

    void fillEnterpriseAuditing(Enterprise_info_auditing enterpriseinfoauditing);

    void upEnterpriseAuditing(Enterprise_info_auditing enterpriseinfoauditing);

    void fillWorkroomAuditing(WorkRoom_info_auditing workRoomInfoauditing);

    void upWorkroomAuditing(WorkRoom_info_auditing workRoomInfoauditing);
}
