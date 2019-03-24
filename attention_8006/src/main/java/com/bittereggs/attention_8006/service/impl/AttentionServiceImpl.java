package com.bittereggs.attention_8006.service.impl;

import com.bittereggs.attention_8006.entity.Attention;
import com.bittereggs.attention_8006.mapper.AttentionMapper;
import com.bittereggs.attention_8006.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 楼中煊
 * @data 2019/3/23
 * @time 23:03
 */
@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private AttentionMapper attentionMapper;

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private final String date =df.format(System.currentTimeMillis());

    @Override
    public String attentionworkroom(String company, String workroom)  {

        //判断工作室是否关注该公司
        if (work_attention_com(company,workroom)){
            //关注了,删除工作室关注表里的数据并往公司和工作室的表里添加数据
            delworkroom(company,workroom);
            if (add_enterprise_attention_workroom(company,workroom)){
                //相互关注成功
            }else {
                //出错
            }
        }else {
            //没有关注
            attentionMapper.attentionworkroom(company,workroom,date);
        }
        return null;
    }

    @Override
    public String attentioncompany(String company, String workroom) {

        if (com_attention_work(company,workroom)){
            //关注了，删除公司关注表里的数据并往相互关注表添加数据
            delcompany(company,workroom);
           if (add_enterprise_attention_workroom(company,workroom)){
               //相互关注成功
           }else {
               //出错
           }
        }else {
            //没有关注
            attentionMapper.attentioncompany(company,workroom,date);
        }
        return null;
    }

    @Override
    public String companyattention(String company) {

        //单向关注
        List<Attention> attentions = this.attentionMapper.companyattention(company);

        //相互关注
        List<Attention> Mutual_attentions = this.attentionMapper.Mutual_attention(company);

        System.out.println(attentions.toString() +"zzzzzzzz" + Mutual_attentions.toString());
        return null;
    }

    @Override
    public String workroomattention(String workroom) {

        List<Attention> attentions = this.attentionMapper.workroomattention(workroom);

        List<Attention> Mutual_attentions = this.attentionMapper.Mutual_attention_workroom(workroom) ;

        System.out.println(attentions.toString()+"zzzzzzzz"+Mutual_attentions.toString());
        return null;
    }



    //判断工作室是否关注该公司
    private Boolean work_attention_com(String company, String workroom)  {
        return attentionMapper.work_attention_com(company,workroom);
    }

    //判断公司是否关注工作室
    private Boolean com_attention_work(String company,String workroom){
        return attentionMapper.com_attention_work(company,workroom);
    }

    private void delworkroom(String company, String workroom){
        this.attentionMapper.delworkroom(company,workroom);
    }

    private void delcompany(String company, String workroom){
        this.attentionMapper.delcompany(company,workroom);
    }

    private Boolean add_enterprise_attention_workroom(String company, String workroom){
        return this.attentionMapper.add_enterprise_attention_workroom(company,workroom,date);
    }

}
