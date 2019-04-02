package com.bittereggs.biddingbook_8007.mapper;

import com.bittereggs.biddingbook_8007.entity.BiddingBook;
import com.bittereggs.biddingbook_8007.entity.Invatation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "BiddingBookMapper")
public interface BiddingBookMapper {

    BiddingBook getBiddingBookInfo(String biddingbookid);

    List<BiddingBook> getNoBiddingBook(BiddingBook biddingBook);

    int releaseBiddingBook(BiddingBook biddingBook);

    int invatationWorkroom(Invatation invatation);
}