package com.bittereggs.admin_8009.controller;

import com.bittereggs.admin_8009.entity.Report;
import com.bittereggs.admin_8009.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/getreport")
    public String getReort(@RequestBody Report report){
        String res = reportService.getReort(report);
        return res;
    }

    @PostMapping("/addreport")
    public String addReport(@RequestBody Report report){
        String res = reportService.addReport(report);
        return res;
    }


}
