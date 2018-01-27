package com.controller.admin;

import com.entity.Goods;
import com.entity.GoodsPage;
import com.entity.Top;
import com.entity.Util;
import com.google.gson.Gson;
import com.service.GoodsImpl;
import com.service.TopServiceImpl;
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
    @Autowired
    private TopServiceImpl topService;
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
        goodsPage.setGoodsList(goodsList);
        session.setAttribute("goodsPage",goodsPage);
        return "adminGoodsList";
    }

    @PostMapping("/PageGoodsList")
    @ResponseBody
    public String PageGoodsList(@RequestParam("Page")Integer ccurrentPage) {
        Integer totalPage=null;

        GoodsPage goodsPage= (GoodsPage) session.getAttribute("goodsPage");
        if (ccurrentPage<=goodsPage.getTotalPage()&&ccurrentPage>0) {
            goodsPage.setCurrentPage(ccurrentPage);
            System.out.println(ccurrentPage);
            List<Goods> goodsList = new ArrayList<Goods>();
            goodsList = goodsImpl.getGoodListByCurrentPagAndGoodsNum((goodsPage.getCurrentPage() - 1) * Util.GOODSNUMINPAGE, Util.GOODSNUMINPAGE);
            goodsPage.setGoodsList(goodsList);
            session.removeAttribute("goodsPage");
            session.setAttribute("goodsPage", goodsPage);
        }
        return new Gson().toJson(goodsPage);
    }

    /**
     * 后台条幅热销新品商品的管理
     * @param status
     * @return
     */
    @PostMapping("/toTopLists")
    @ResponseBody
    public String getTopGoods(@RequestParam("status")Integer status){
        System.out.println(status);

        List<Top> topList=topService.getTopListByTypeId(status);

        List<Goods> goodsList=new ArrayList<Goods>();

        for (Top top:topList) {
            if (status==top.getTypeId()) {
                goodsList.add(goodsImpl.getGoodByGoodId(top.getGoodId()));
            }
        }
        return  new Gson().toJson(goodsList);
    }

    /**
     * 实现商品管理移入条幅等功能
     * @param goodId
     * @param typeId
     * @return
     */
    @PostMapping("/topSave")
    @ResponseBody
    public  String topSave(@RequestParam("goodId")Integer goodId,@RequestParam("typeId")Integer typeId){

        Integer num= null;
        try {
            num = topService.insertTop(goodId,typeId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Gson().toJson(num);
    }

    /**
     * 后台商品删除
     * @param goodId
     * @return
     */
    @PostMapping("/adminGoodDelete")
    @ResponseBody
    public String GoodDelete(@RequestParam("goodId")Integer goodId){
        Integer num=goodsImpl.deleteGoodById(goodId);

        return new Gson().toJson(num);
    }
    /**
     * 推荐热销新品商品删除
     * @param goodId
     * @return
     */
    @PostMapping("/topGoodDelete")
    @ResponseBody
    public String topGoodDelete(@RequestParam("goodId")Integer goodId,@RequestParam("typeId")Integer typeId){
        Integer num=topService.deleteTopByGoodIdAndType(goodId,typeId);

        return new Gson().toJson(num);
    }
}
