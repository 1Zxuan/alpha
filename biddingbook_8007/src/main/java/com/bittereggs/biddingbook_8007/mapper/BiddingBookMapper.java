package com.bittereggs.biddingbook_8007.mapper;

import com.bittereggs.biddingbook_8007.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "BiddingBookMapper")
public interface BiddingBookMapper {

    BiddingBook getBiddingBookInfo(String biddingbookid);

    List<BiddingBook> getNoBiddingBook(BiddingBook biddingBook);

    void releaseBiddingBook(BiddingBook biddingBook);

    int invatationWorkroom(Invatation invatation);

    List<Tender_info> getWinBiddingBook(String workroomusername);

    int initiateBidding(Tender_info tender_info);

    String findWorkroom(String workroom_username,String biddingbookid);

    int upinitiateBidding(Tender_info tender_info);

    Invatation getWorkroomIniate(String workroomname);

    List<Tender_info> getCompanyBidd(String biddingbookid);

    void releasePhase(BiddingBook biddingBook);

    String confirmOrder(Phase phase);

    Phase getphase(String biddingbookid);

    Phase getPhase(String biddingbookid);

    void passPhase(String document, String picture,String biddingbookid);

    boolean getBlack(String username);
}
