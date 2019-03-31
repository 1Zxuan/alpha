package com.alpha.findinfromatin_8003.mapper;

import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.WorkRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FindInformationMapper {

    WorkRoom getWorkRoom(String workroom_username);

    List<WorkRoom> getAllWorkRoom(int p);

    List<WorkRoom> searchWorkRoom(String key);

    Enterprise getEnterprise(String company_username);
}
