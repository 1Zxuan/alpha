package com.alpha.findinfromatin_8003.mapper;

import com.alpha.findinfromatin_8003.entity.BiddingBook;
import com.alpha.findinfromatin_8003.entity.WorkRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FindInformationMapper {

    WorkRoom getWorkRoom(String workroom_username);

    BiddingBook getBiddingBook(String bidding_name);

    List<WorkRoom> getAllWorkRoom(int p);

    List<WorkRoom> searchWorkRoom(String key);

    List<BiddingBook>  getAllBiddingBook(@Param("p") int p, @Param("order") String order);
}