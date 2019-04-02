package com.bittereggs.money.mapper;

import com.bittereggs.money.entity.Advertisement;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 楼中煊
 * @data 2019/4/1
 * @time 19:52
 */
@Mapper
public interface ADMapper {

    void applyAD(Advertisement advertisement);

}
