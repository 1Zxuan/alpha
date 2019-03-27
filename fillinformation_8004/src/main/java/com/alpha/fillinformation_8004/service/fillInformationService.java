package com.alpha.fillinformation_8004.service;

import com.alpha.fillinformation_8004.entity.*;

public interface fillInformationService {

    String upUserInfo(User user);

    String fillEnterpriseAuditing(Enterprise_info_auditing enterpriseinfoauditing);

    String fillWorkroomAuditing(WorkRoom_info_auditing workRoomInfoauditing);
}
