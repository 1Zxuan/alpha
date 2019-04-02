package com.bittereggs.biddingbook_8007.controller;

import com.bittereggs.biddingbook_8007.entity.BiddingBook;
import com.bittereggs.biddingbook_8007.entity.Invatation;
import com.bittereggs.biddingbook_8007.entity.Phase;
import com.bittereggs.biddingbook_8007.entity.Tender_info;
import com.bittereggs.biddingbook_8007.service.BiddingBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class BiddingBookController {

    @Autowired
    private BiddingBookService biddingBookService;

    //查看中标的所有招标书
    @GetMapping("/getwinbiddingbook")
    public String getWinBiddingBook(@RequestParam("workroomusername") String workroomusername){
        String res = biddingBookService.getWinBiddingBook(workroomusername);
        return res;
    }
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

    //查找所有未完成招标书(筛选排序)
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

    //工作室投标
    @PostMapping("/initiatebidding")
    public String initiateBidding(@RequestBody Tender_info tender_info){
        System.out.println(tender_info.toString());
        String res = biddingBookService.initiateBidding(tender_info);
        return res;
    }

    //工作室查看被邀请投标
    @GetMapping("/getworkroominiate")
    public String getWorkroomIniate(@RequestParam("workroomusername") String workroomname){
        String res = biddingBookService.getWorkroomIniate(workroomname);
        return res;
    }

    //查看招标书投标的工作室
    @GetMapping("/getcompanybidd")
    public String getCompanyBidd(@RequestParam("biddingbookid") String biddingbookid){
        String res = biddingBookService.getCompanyBidd(biddingbookid);
        return res;
    }

    //企业确认订单
    @GetMapping("/confirmorder")
    public String confirmOrder(@RequestBody Phase phase){
        String res = biddingBookService.confirmOrder(phase);
        return res;
    }

    //阶段查看
    @GetMapping("/getphase")
    public String getPhase(@RequestParam("biddingbookid") String biddingbookid){
        String res = biddingBookService.getPhase(biddingbookid);
        return res;
    }
    //阶段审核通过
    @GetMapping("/passphase")
    public String passPhase(@RequestParam("document") String document,
                            @RequestParam("picture") String picture,
                            @RequestParam("biddingbookid") String biddingbookid){
        String res=biddingBookService.passPhase(document,picture,biddingbookid);
        return res;


    }

}
