package com.alpha.fillinformation_8004.mapper;

import com.alpha.fillinformation_8004.entity.Enterprise;
import com.alpha.fillinformation_8004.entity.WorkRoom;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface fillInformationMapper {

    void fillenterprise(Enterprise enterprise);

    void fillworkroom(WorkRoom workRoom);

    Boolean findenterpriseusername(String company_username);
    

    void upfillenterprise(Enterprise enterprise);

    void upfillworkroom(WorkRoom workRoom);

    boolean findworkroomusername(String workroom_username);
}
