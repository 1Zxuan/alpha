package com.bittereggs.attention_8006.service;

/**
 * @author 楼中煊
 * @data 2019/3/23
 * @time 23:02
 */
public interface AttentionService {

    String attentionworkroom(String company, String workroom);

    String attentioncompany(String company, String workroom);

    String companyattention(String company);

    String workroomattention(String workroom);

}
