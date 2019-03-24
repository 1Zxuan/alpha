package com.bittereggs.upload_8005.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 楼中煊
 * @data 2019/3/22
 * @time 12:03
 */

@RestController
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @PostMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return "空文件,无法上传!";
        }
        String filename = file.getOriginalFilename();

        //设置文件上次路径
        String filepath = "";
        File dest = new File(filepath + filename);
        try {
            file.transferTo(dest);
            LOGGER.info(filename + "文件上传成功至" + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
