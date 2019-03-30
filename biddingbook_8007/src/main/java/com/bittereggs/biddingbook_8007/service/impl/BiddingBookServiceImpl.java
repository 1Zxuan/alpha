package com.bittereggs.biddingbook_8007.service.impl;

import com.bittereggs.biddingbook_8007.entity.BiddingBook;
import com.bittereggs.biddingbook_8007.entity.Invatation;
import com.bittereggs.biddingbook_8007.mapper.BiddingBookMapper;
import com.bittereggs.biddingbook_8007.service.BiddingBookService;
import com.bittereggs.biddingbook_8007.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BiddingBookServiceImpl implements BiddingBookService {

    public static volatile int Guid=100;

    @Autowired
    private BiddingBookMapper biddingBookMapper;

        //  生成biddingbookid
        public static String getGuid() {
            Guid += 1;
            long now = System.currentTimeMillis();
            //获取4位年份数字
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            //获取时间戳
            String time = dateFormat.format(now);
            String info = now + "";
            //获取三位随机数
            //int ran=(int) ((Math.random()*9+1)*100);
            //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
            int ran = 0;
            if (Guid > 999) {
                Guid = 100;
            }
            ran = Guid;
            return time + info.substring(2, info.length()) + ran;
        }

    @Override
    public String releaseBiddingBook(BiddingBook biddingBook) {
        long day=0;
        Date d1 = biddingBook.getProject_endtime();
        Date d2 = biddingBook.getRelease_time();
        day = (d1.getTime()-d2.getTime())/(24*60*60*1000);
        biddingBook.setBiddingbookid(getGuid());
        biddingBook.setEngineer_time((int)day);
        JSONObject jsonObject = new JSONObject();
        if(biddingBookMapper.releaseBiddingBook(biddingBook)>0)
            jsonObject.put("msg","success");
        else
            jsonObject.put("msg","error");
        return jsonObject.toString();
    }

    @Override
    public String getBiddingBookInfo(String biddingbookid) {
        BiddingBook biddingBook = biddingBookMapper.getBiddingBookInfo(biddingbookid);
        if (biddingBook!=null){
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            JSONObject jsonArray = JSONObject.fromObject(biddingBook,jsonConfig);
            return jsonArray.toString();
        }
        else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg","error");
            return jsonObject.toString();
        }
    }

    @Override
    public String getNoBiddingBook(BiddingBook biddingBook) {
        int page=biddingBook.getPage();
        int p =0;
        if( page>=1 ){
            p = page*10+1;
        }else{
            p=0;
        }
        biddingBook.setPage(p);
        List<BiddingBook> list = biddingBookMapper.getNoBiddingBook(biddingBook);
        if(list.size()>0) {
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
            JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
            return jsonArray.toString();
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg","error");
            return jsonObject.toString();
        }
    }

    @Override
    public String invatationWorkroom(Invatation invatation) {
        JSONObject jsonObject = new JSONObject();
        if(biddingBookMapper.invatationWorkroom(invatation)>0)
            jsonObject.put("msg","success");
        else
            jsonObject.put("msg","error");
        return jsonObject.toString();
    }
}
