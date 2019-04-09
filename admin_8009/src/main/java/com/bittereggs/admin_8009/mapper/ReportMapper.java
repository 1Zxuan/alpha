package com.bittereggs.admin_8009.mapper;

import com.bittereggs.admin_8009.entity.Report;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "ReportMapper")
public interface ReportMapper {
    List<Report> getReport(Report report);

    void addReport(Report report);

    void upReport(Report report);
}
