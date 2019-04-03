package com.bittereggs.admin_8009.mapper;

import com.bittereggs.admin_8009.entity.Enterprise;
import com.bittereggs.admin_8009.entity.WorkRoom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "AdminMapper")
public interface AdminMapper {
    List<WorkRoom> getWorkRoomAud(String status);

    List<Enterprise> getEnterpriseAud(String status);
}
