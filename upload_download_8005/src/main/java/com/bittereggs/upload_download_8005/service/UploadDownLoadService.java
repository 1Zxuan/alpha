package com.bittereggs.upload_download_8005.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 楼中煊
 * @data 2019/3/23
 * @time 19:35
 */
public interface UploadDownLoadService {

    String upload(MultipartFile file, String username);

    void download(HttpServletResponse response,String filename ,String username);
}
