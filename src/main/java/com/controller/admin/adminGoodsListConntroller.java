package com.controller.admin;

import com.entity.Goods;
import com.entity.GoodsPage;
import com.entity.Util;
import com.google.gson.Gson;
import com.service.GoodsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
public class adminGoodsListConntroller {
    @Autowired
    private GoodsImpl goodsImpl;
    @Autowired
    private HttpSession session;
    @GetMapping("/GoodsList")
    public String GoodsList() {

        Integer totalPage=null;
        GoodsPage goodsPage=new GoodsPage();
        goodsPage.setCurrentPage(1);
        if ((goodsImpl.getGoodsTotalNum()%Util.GOODSNUMINPAGE)==0){
            totalPage=goodsImpl.getGoodsTotalNum()/Util.GOODSNUMINPAGE;
        }else {
            totalPage= goodsImpl.getGoodsTotalNum()/Util.GOODSNUMINPAGE+1;
        }
        goodsPage.setGoodsNumInPage(Util.GOODSNUMINPAGE);
        goodsPage.setTotalPage(totalPage);
        List<Goods> goodsList=new ArrayList<Goods>();
        goodsList=goodsImpl.getGoodListByCurrentPagAndGoodsNum(0,Util.GOODSNUMINPAGE);
        System.out.println(goodsList);

        goodsPage.setGoodsList(goodsList);
        session.setAttribute("goodsPage",goodsPage);
        System.out.println(goodsList);
        return "adminGoodsList";
    }

    @PostMapping("/PageGoodsList")
    @ResponseBody
    public String PageGoodsList(@RequestParam("currentPage")Integer ccurrentPage) {
        Integer totalPage=null;
        GoodsPage goodsPage=new GoodsPage();
        goodsPage.setCurrentPage(ccurrentPage);
        if ((goodsImpl.getGoodsTotalNum()%Util.GOODSNUMINPAGE)==0){
            totalPage=goodsImpl.getGoodsTotalNum()/Util.GOODSNUMINPAGE;
        }else {
            totalPage= goodsImpl.getGoodsTotalNum()/Util.GOODSNUMINPAGE+1;
        }
        goodsPage.setGoodsNumInPage(Util.GOODSNUMINPAGE);
        goodsPage.setTotalPage(totalPage);
        List<Goods> goodsList=new ArrayList<Goods>();
        goodsList=goodsImpl.getGoodListByCurrentPagAndGoodsNum(goodsPage.getCurrentPage(),Util.GOODSNUMINPAGE);

        goodsPage.setGoodsList(goodsList);
        return new Gson().toJson(goodsPage);
    }
}
