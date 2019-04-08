package com.bittereggs.admin_8009.service;

import com.bittereggs.admin_8009.entity.Report;

public interface ReportService {

    String getReport(Report report);

    String addReport(Report report);

    String upReport(Report report);
}
