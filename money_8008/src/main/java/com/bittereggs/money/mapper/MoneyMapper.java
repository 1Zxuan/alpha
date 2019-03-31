package com.bittereggs.money.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author 楼中煊
 * @data 2019/3/30
 * @time 16:53
 */

@Mapper
public interface MoneyMapper {

    void recharge (@Param("0")String username, @Param("1")Double money, @Param("2")String inoutmoney,@Param("3")Integer type);

    void withdraw(@Param("0")String username, @Param("1")Double money, @Param("2")String inoutmoney,@Param("3")Integer type);

    void companypay(@Param("0")String username, @Param("1")Double money, @Param("2")String inoutmoney,@Param("3")Integer type);

    void workroomreceipt(@Param("0")String username, @Param("1")Double money, @Param("2")String inoutmoney,@Param("3")Integer type);

    void adminupdate(@Param("0")Double balance);

    Double selectadminbalance();

    Boolean checkpaypassword(@Param("0")String username, @Param("1")String paypassword);
}
