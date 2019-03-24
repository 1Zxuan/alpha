package com.bittereggs.attention_8006.service.impl;

import com.bittereggs.attention_8006.mapper.UnAttentionMapper;
import com.bittereggs.attention_8006.service.UnAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

/**
 * @author 楼中煊
 * @data 2019/3/24
 * @time 14:13
 */

@Service
public class UnAttentionServiceImpl implements UnAttentionService {

    @Autowired
    private UnAttentionMapper unAttentionMapper;

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    private final String date =df.format(System.currentTimeMillis());

    @Override
    public void companycancelworkroom(String company, String workroom) {
        //判断是否相互关注
        if (enterprise_attention_workroom(company,workroom)){
            //相互关注,删除相互关注表中数据，往工作室关注表中插入相应数据
            unAttentionMapper.delMutualattention(company,workroom);
            unAttentionMapper.addworkroom(company,workroom,date);
        }else {
            //删除公司关注表中的相关记录
            this.unAttentionMapper.delcompany(company,workroom);
        }
    }

    @Override
    public void workroomcancelcompany(String company, String workroom) {
        if (enterprise_attention_workroom(company,workroom)){
            unAttentionMapper.delMutualattention(company,workroom);
            unAttentionMapper.addcompany(company,workroom,date);
        }else {
            this.unAttentionMapper.delworkroom(company,workroom);
        }
    }

    //判断公司和工作室是否相互关注
    private Boolean enterprise_attention_workroom(String company,String workroom) {
        return unAttentionMapper.enter_atten_work(company,workroom);
    }
}
