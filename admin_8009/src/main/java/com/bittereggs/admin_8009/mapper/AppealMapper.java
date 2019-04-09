package com.bittereggs.admin_8009.mapper;

import com.bittereggs.admin_8009.entity.Appeal;
import com.bittereggs.admin_8009.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "AppealMapper")
public interface AppealMapper {

    List<Report> getAppeal(Appeal appeal);

    void addAppeal(Appeal appeal);

    void upAppeal(Appeal appeal);
}
