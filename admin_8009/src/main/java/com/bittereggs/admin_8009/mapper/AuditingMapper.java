package com.bittereggs.admin_8009.mapper;

import com.bittereggs.admin_8009.entity.Blacklist;
import com.bittereggs.admin_8009.entity.Enterprise_aud;
import com.bittereggs.admin_8009.entity.Workroom_aud;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "AdminMapper")
public interface AuditingMapper {


    List<Workroom_aud> getWorkroomAud(Workroom_aud workroom_aud);

    List<Workroom_aud> getEnterpriseAud(Enterprise_aud enterprise_aud);

    void upPassWorkroom(Workroom_aud workroom_aud);

    void upPassEnterprise(Enterprise_aud enterprise_aud);
}

