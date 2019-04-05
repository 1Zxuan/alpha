package com.bittereggs.admin_8009.service;

import com.bittereggs.admin_8009.entity.Blacklist;
import com.bittereggs.admin_8009.entity.Enterprise_aud;
import com.bittereggs.admin_8009.entity.Workroom_aud;

public interface AuditingService {


    String getWorkroomAud(Workroom_aud workroom_aud);

    String getEnterpriseAud(Enterprise_aud enterprise_aud);

    String upPassWorkroom(Workroom_aud workroom_aud);

    String upPassEnterprise(Enterprise_aud enterprise_aud);


}
