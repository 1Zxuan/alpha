package com.bittereggs.biddingbook_8007.service;

import com.bittereggs.biddingbook_8007.entity.BiddingBook;
import com.bittereggs.biddingbook_8007.entity.Invatation;


public interface BiddingBookService {
    String releaseBiddingBook(BiddingBook biddingBook);

    String getBiddingBookInfo(String biddingbookid);

    String getNoBiddingBook(BiddingBook biddingBook);

    String invatationWorkroom(Invatation invatation);
}
