package com.alpha.findinfromatin_8003.mapper;

import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.WorkRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "FindInformationMapper")
public interface FindInformationMapper {

    WorkRoom getWorkRoom(String workroom_username);

    List<WorkRoom> getAllWorkRoom(@Param("p") int p, @Param("goodfield") String goodfield);

    List<WorkRoom> searchWorkRoom(String key);

    Enterprise getEnterprise(String company_username);
}
