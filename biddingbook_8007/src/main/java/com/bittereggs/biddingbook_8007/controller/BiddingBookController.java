package com.bittereggs.biddingbook_8007.controller;

import com.bittereggs.biddingbook_8007.entity.BiddingBook;
import com.bittereggs.biddingbook_8007.entity.Invatation;
import com.bittereggs.biddingbook_8007.service.BiddingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BiddingBookController {

    @Autowired
    private BiddingBookService biddingBookService;

    //邀请招标
    @PostMapping("/invatationworkroom")
    public String invatationWorkroom(@RequestBody Invatation invatation){
        System.out.println(invatation.toString());
        String res = biddingBookService.invatationWorkroom(invatation);
        return res;
    }

    //发布招标书
    @PostMapping("/releasebiddingbook")
    public String releaseBiddingBook(@RequestBody BiddingBook biddingBook){
        System.out.println(biddingBook.toString());
        String res = biddingBookService.releaseBiddingBook(biddingBook);
        return res;
    }

    //查找所有未完成招标书
    @PostMapping("/getnobiddingbook")
    public String getNoBiddingBook(@RequestBody BiddingBook biddingBook){
        System.out.println(biddingBook);
        String res =  biddingBookService.getNoBiddingBook(biddingBook);
        return res;
    }

    //招标书详情查看
    @GetMapping("/getbiddingbookinfo")
    public String getBiddingBookInfo(@RequestParam("biddingbookid") String biddingbookid){
        System.out.println(biddingbookid);
        String res = biddingBookService.getBiddingBookInfo(biddingbookid);
        return res;
    }

}
