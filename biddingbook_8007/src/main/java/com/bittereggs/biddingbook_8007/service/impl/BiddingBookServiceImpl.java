package com.bittereggs.biddingbook_8007.service.impl;

import com.bittereggs.biddingbook_8007.entity.*;
import com.bittereggs.biddingbook_8007.mapper.BiddingBookMapper;
import com.bittereggs.biddingbook_8007.service.BiddingBookService;
import com.bittereggs.biddingbook_8007.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BiddingBookServiceImpl implements BiddingBookService {

    public static volatile int Guid=100;

    @Autowired
    private BiddingBookMapper biddingBookMapper;

        //  生成biddingbookid
        private static String getGuid() {
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
        //是否在黑名单
    public boolean getBlack(String username){
            if(!biddingBookMapper.getBlack(username)){
                return true;
            }else
                return false;
    }
    // 判断是否存在工作室
    public boolean findworkroom(String workroom_username,String biddingbookid){
        if(biddingBookMapper.findWorkroom(workroom_username,biddingbookid)!=null)
            return false;
        else
            return true;
    }
    //发布招标书
    @Override
    public String releaseBiddingBook(BiddingBook biddingBook) {
        long day=0;
        Date d1 = biddingBook.getProject_endtime();
        Date d2 = biddingBook.getRelease_time();
        day = (d1.getTime()-d2.getTime())/(24*60*60*1000);
        biddingBook.setBiddingbookid(getGuid());
        biddingBook.setEngineer_time((int)day);
        JSONObject jsonObject = new JSONObject();
        try{
            if(getBlack(biddingBook.getCompany_username())){
                biddingBookMapper.releaseBiddingBook(biddingBook);
                biddingBookMapper.releasePhase(biddingBook);
                jsonObject.put("msg","success");
            }else{
                //在黑名单
                jsonObject.put("msg", "inblack");
            }
        }catch(Exception e) {
            System.out.println(e);
            jsonObject.put("msg", "error");
        }
        return jsonObject.toString();
    }
    //获取招标书详细信息
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
    //查找所有未完成招标书
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
    //邀请招标
    @Override
    public String invatationWorkroom(Invatation invatation) {
        JSONObject jsonObject = new JSONObject();
        if(getBlack(invatation.getCompany_username())){
            if(biddingBookMapper.invatationWorkroom(invatation)>0)
                jsonObject.put("msg","success");
            else
                jsonObject.put("msg","error");
        }else{
            jsonObject.put("msg","inblack");
        }

        return jsonObject.toString();
    }
    //查看中标的所有招标书
    @Override
    public String getWinBiddingBook(String workroomusername) {
        List<Tender_info> list= biddingBookMapper.getWinBiddingBook(workroomusername);
        if(list.size()>0) {
           JSONArray jsonarray = JSONArray.fromObject(list);
            return jsonarray.toString();
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg","error");
            return jsonObject.toString();
        }
    }
    //工作室投标
    @Override
    public String initiateBidding(Tender_info tender_info) {
            System.out.println(tender_info.toString());
        JSONObject jsonObject = new JSONObject();
        if(getBlack(tender_info.getWorkroom_username())){
            //true添加
            if(findworkroom(tender_info.getWorkroom_username(),tender_info.getBiddingbookid())){
                if(biddingBookMapper.initiateBidding(tender_info)>0)
                    jsonObject.put("msg","success");
                else
                    jsonObject.put("msg","error");
            }else{
                if(biddingBookMapper.upinitiateBidding(tender_info)>0)
                    jsonObject.put("msg","success");
                else
                    jsonObject.put("msg","error");
            }
        }else{
            jsonObject.put("msg","inblack");
        }

        return jsonObject.toString();
    }
    //工作室查看被邀请投标
    @Override
    public String getWorkroomIniate(String workroomname) {
        JSONObject jsonObject;
        Invatation invatation = biddingBookMapper.getWorkroomIniate(workroomname);
        if(invatation!=null){
            jsonObject=JSONObject.fromObject(invatation);
            return jsonObject.toString();
        }else{
            jsonObject = new JSONObject();
            jsonObject.put("msg","error");
            return jsonObject.toString();
        }
    }
    //查看招标书投标的工作室
    @Override
    public String getCompanyBidd(String biddingbookid) {
        List<Tender_info> list = biddingBookMapper.getCompanyBidd(biddingbookid);
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }
    //企业确认订单
    @Override
    public String confirmOrder(Phase phase) {
            JSONObject jsonObject = new JSONObject();
        try {
            if(getBlack(phase.getEnterprise_username())){
                phase.setPhase_name(biddingBookMapper.getphase(phase.getBiddingbookid()).getPhase_name());
                phase.setPhase_price(getphase(phase.getBiddingbookid(),phase.getProject_price()));
                phase.setOrder_id(getGuid());
                System.out.println(phase.toString());
                biddingBookMapper.confirmOrder(phase);
                jsonObject.put("msg","success");
            }else{
                jsonObject.put("msg","inblack");
            }
        }catch(Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }
    //阶段查看
    @Override
    public String getPhase(String biddingbookid) {
        Phase phase = biddingBookMapper.getPhase(biddingbookid);
//        JSONObject jsonObject = JSONObject.fromObject(phase);
        return formatdata(phase);
    }
    //阶段审核通过
    @Override
    public String passPhase(String document, String picture,String biddingbookid) {
        JSONObject jsonObject = new JSONObject();
        try {
            biddingBookMapper.passPhase(document, picture,biddingbookid);
            jsonObject.put("msg","success");
        }catch(Exception e){
            System.out.println(e);
            jsonObject.put("msg","error");
        }
        return jsonObject.toString();
    }

    public String getphase(String biddingbookid,String price){
        Phase p = biddingBookMapper.getphase(biddingbookid);
        String str="";
        String[] phaseprice;
        double s;
        phaseprice = p.getDeposit().split("/");
        for (int i = 0; i < phaseprice.length; i++) {
            s = Double.valueOf(phaseprice[i]);
            s *= Double.valueOf(price);
            str = str + s + "/";
        }
        return str;
    }

    private String formatdata(Phase phase){
        List<String> phase_name = list(phase.getPhase_name());
        List<String> deposit = list(phase.getDeposit());
        List<String> document = list(phase.getDocument());
        List<String> finish = list(phase.getFinish());
        List<String> picture = list(phase.getPicture());
        List<String> pay_state = list(phase.getPay_state());
        List<String> phase_price = list(phase.getPhase_price());
        List<Phase> list = new ArrayList<>();
        for (int i = 0; i < phase_name.size(); i++){
            Phase temp = new Phase
                    (   phase.getBiddingbookid(),
                        phase.getWorkroomusername(),
                        phase_name.get(i),
                        deposit.get(i),
                        document.get(i),
                        finish.get(i),
                        picture.get(i),
                        pay_state.get(i),
                        phase.getOrder_id(),
                        phase.getEnterprise_username(),
                        phase.getProject_price(),
                        phase_price.get(i)
                    );
            list.add(temp);
        }
        JSONArray result = JSONArray.fromObject(list);
        return result.toString();
    }

    private List<String> list (String string){
        List<String> list = new ArrayList<>();
        for (int i = 0,s=string.length(); i < s;){
            if (string.charAt(i) == '/'){
                list.add(string.substring(0,i));
                string = string.replace(string.substring(0,i+1),"");
                s = string.length();
                i=0;
            } else {
                i++;
            }
        }
        return list;
    }
}
