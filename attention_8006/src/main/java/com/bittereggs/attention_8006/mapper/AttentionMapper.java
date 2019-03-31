package com.bittereggs.attention_8006.mapper;

import com.bittereggs.attention_8006.entity.Attention;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 楼中煊
 * @data 2019/3/23
 * @time 23:04
 */

@Mapper
public interface AttentionMapper {

    void attentionworkroom (@Param("company") String company, @Param("workroom")  String workroom, @Param("attention_date")  String attention_date);

    void attentioncompany (@Param("company") String company, @Param("workroom")  String workroom, @Param("attention_date")  String attention_date);

    List<Attention> companyattention (String company);

    List<Attention> workroomattention (String workroom) ;

    List<Attention> Mutual_attention (String company);

    List<Attention> Mutual_attention_workroom (String workroom);

    Boolean work_attention_com (@Param("company") String company,@Param("workroom") String workroom) ;

    Boolean com_attention_work (@Param("company") String company,@Param("workroom") String workroom) ;

    Boolean add_enterprise_attention_workroom(@Param("company") String company,@Param("workroom") String workroom, @Param("date") String date);

    void delworkroom(@Param("company") String company,@Param("workroom") String workroom);

    void delcompany(@Param("company") String company,@Param("workroom") String workroom);
}
