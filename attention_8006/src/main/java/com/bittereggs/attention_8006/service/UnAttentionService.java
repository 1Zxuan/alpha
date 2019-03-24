package com.bittereggs.attention_8006.service;

/**
 * @author 楼中煊
 * @data 2019/3/24
 * @time 14:13
 */


public interface UnAttentionService {

    void companycancelworkroom(String company,String workroom);

    void workroomcancelcompany(String company,String workroom);
}
