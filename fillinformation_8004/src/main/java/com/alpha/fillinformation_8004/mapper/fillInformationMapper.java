package com.alpha.fillinformation_8004.mapper;

import com.alpha.fillinformation_8004.entity.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface fillInformationMapper {

    Boolean findenterpriseusername(String company_username);

    Boolean findworkroomusername(String workroom_username);

    void upUserInfo(User user);

    void fillEnterpriseAuditing(Enterprise_info_auditing enterpriseinfoauditing);

    void upEnterpriseAuditing(Enterprise_info_auditing enterpriseinfoauditing);

    void fillWorkroomAuditing(WorkRoom_info_auditing workRoomInfoauditing);

    void upWorkroomAuditing(WorkRoom_info_auditing workRoomInfoauditing);
}
