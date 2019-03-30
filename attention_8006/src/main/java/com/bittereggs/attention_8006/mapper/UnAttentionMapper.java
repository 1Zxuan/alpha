package com.bittereggs.attention_8006.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author 楼中煊
 * @data 2019/3/24
 * @time 14:13
 */

@Mapper
@Component(value = "UnAttentionMapper")
public interface UnAttentionMapper {

    Boolean enter_atten_work (@Param("company") String company, @Param("workroom") String workroom);

    void delworkroom(@Param("company") String company,@Param("workroom") String workroom);

    void delcompany(@Param("company") String company,@Param("workroom") String workroom);

    void delMutualattention(@Param("company") String company,@Param("workroom") String workroom);

    Boolean addworkroom(@Param("company") String company,@Param("workroom") String workroom,@Param("date") String date);

    Boolean addcompany(@Param("company") String company,@Param("workroom") String workroom,@Param("date") String date);
}
