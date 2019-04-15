package com.bittereggs.biddingbook_8007.service;

import com.bittereggs.biddingbook_8007.entity.BiddingBook;
import com.bittereggs.biddingbook_8007.entity.Invatation;
import com.bittereggs.biddingbook_8007.entity.Phase;
import com.bittereggs.biddingbook_8007.entity.Tender_info;


public interface BiddingBookService {
    String releaseBiddingBook(BiddingBook biddingBook);

    String getBiddingBookInfo(String biddingbookid);

    String getNoBiddingBook(BiddingBook biddingBook);

    String invatationWorkroom(Invatation invatation);

    String getWinBiddingBook(String workroomusername);

    String initiateBidding(Tender_info tender_info);

    String getWorkroomIniate(String workroomname);

    String getCompanyBidd(String biddingbookid);

    String confirmOrder(Phase phase);

    String getPhase(String biddingbookid);

    String passPhase(String document, String picture,String biddingbookid);

    String agreeIniateWorkroom(Invatation invatation);
}
