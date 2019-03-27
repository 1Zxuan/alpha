package com.alpha.findinfromatin_8003.mapper;

import com.alpha.findinfromatin_8003.entity.BiddingBook;
import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.User;
import com.alpha.findinfromatin_8003.entity.WorkRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FindInformationMapper {

    WorkRoom getWorkRoom(String workroom_username);


    List<WorkRoom> getAllWorkRoom(int p);

    List<WorkRoom> searchWorkRoom(String key);

    List<BiddingBook>  getAllBiddingBook(@Param("p") int p, @Param("order") String order);

    Enterprise getEnterprise(String company_username);

    List<Enterprise> getBeforBiddingbook(String company_username);

    User getUserInfo(String username);
}
