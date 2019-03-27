package com.bittereggs.upload_download_8005.service.impl;

import com.bittereggs.upload_download_8005.service.UploadDownLoadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.java2d.loops.FillPath;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 * @author 楼中煊
 * @data 2019/3/23
 * @time 19:35
 */
@Service
public class UploadDownLoadServiceImpl implements UploadDownLoadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadDownLoadServiceImpl.class);

    private String FilePath = "D:\\temp\\";//设置上传主目录

    @Override
    public String upload(MultipartFile file, String username) {
        judeDirExists(new File(FilePath +"\\" + username));
        String filename = file.getOriginalFilename();
        filename = judeFileExists(new File(FilePath + "\\" + username + "\\" + filename),filename);
        //设置文件上次路径
        File dest = new File(FilePath + "\\" + username + "\\" + filename);
        try {
            file.transferTo(dest);
            LOGGER.info(filename + "文件上传成功至" + FilePath + "\\"+ username);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return "上传失败";
    }

    @Override
    public void download(HttpServletResponse response, String filename, String username) {
        File file = new File(FilePath + "\\" + username + "\\" + filename);
        if (file.exists()){
            LOGGER.info("文件存在");
            response.setHeader("Content-Disposition","attachment;fileName="+filename);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            OutputStream os = null;
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            LOGGER.info("文件不存在");
        }
    }

    private void judeDirExists(File file){
        if(file.exists()){
            if(file.isDirectory()){
                LOGGER.info("dir exists");
            }else {
                LOGGER.info("this same name file exists,can't create dir");
            }
        }else {
            LOGGER.info("dir not exists,create it ...");
            file.mkdir();
        }
    }

    //判断文件是否存在
    private String judeFileExists(File file,String username) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        username = df.format(System.currentTimeMillis()) + "_" + username;
        return username;
    }

}
