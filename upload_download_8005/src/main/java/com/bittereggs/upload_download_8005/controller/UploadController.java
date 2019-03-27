package com.bittereggs.upload_download_8005.controller;

import com.bittereggs.upload_download_8005.service.UploadDownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 楼中煊
 * @data 2019/3/22
 * @time 12:03
 */

@RestController
public class UploadController {

    @Autowired
    private UploadDownLoadService uploadDownLoadService;

    @PostMapping("/upload")
    public String upload(@RequestParam(value = "file" ,required = false)MultipartFile file,
                         @RequestParam(value = "username" ,required = false) String username ){
        System.out.println(username);
        return this.uploadDownLoadService.upload(file,username);
    }

    @GetMapping("/download")
    public String download(HttpServletResponse response,@RequestParam("filename") String filename, @RequestParam("username") String username){
        this.uploadDownLoadService.download(response,filename,username);
        return null;
    }

    @PostMapping("/wxload")
    public String wxload(@RequestParam(value = "file" ,required = false)MultipartFile file,
                         @RequestParam(value = "username" ,required = false) String username ){
        return this.uploadDownLoadService.upload(file,username);
    }
}
