package com.bittereggs.admin_8009.controller;

import com.bittereggs.admin_8009.entity.Report;
import com.bittereggs.admin_8009.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/getreport")
    public String getReport(@RequestBody Report report){
        String res = reportService.getReport(report);
        return res;
    }

    @PostMapping("/addreport")
    public String addReport(@RequestBody Report report){
        String res = reportService.addReport(report);
        return res;
    }

    @GetMapping("/upreport")
    public String upReport(@RequestBody Report report){
        String res = reportService.upReport(report);
        return res;
    }

}
