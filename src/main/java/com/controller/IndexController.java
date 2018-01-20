package com.controller;

import com.entity.Goods;
import com.entity.Top;
import com.entity.Types;
import com.google.gson.Gson;
import com.service.GoodsImpl;
import com.service.GoodsTypesImpl;
import com.service.ITopService;
import com.service.TopServiceImpl;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@CrossOrigin
@Controller
@SessionAttributes({"typeList","topList1","topList2","topList3","cartGoodList"})
public class IndexController {
    @Autowired
   private TopServiceImpl topService;

    @Autowired
    private GoodsTypesImpl goodsTypes;

    @Autowired
    private GoodsImpl goodsImpl;

    @Autowired
    private HttpSession session;

    @GetMapping("/index")
    public String getTypes(Model model){

        try {
//            //进行查询
//            List<Top> topList = topService.getTopList();
//            model.addAttribute("topList",topList);
            //根据typeId查询
            List<Top> topList1 = topService.getTopListByTypeId(1);
            model.addAttribute("topList1",topList1);
            List<Top> topList2 = topService.getTopListByTypeId(2);
            model.addAttribute("topList2",topList2);
            List<Top> topList3 = topService.getTopListByTypeId(3);
            model.addAttribute("topList3",topList3);
            List<Types> typeList=goodsTypes.getGoodTypeLIst();
            model.addAttribute("typeList",typeList);
//            System.out.println(topList1);

        }catch (Exception e){
            e.printStackTrace();
        }

     return "index";
    }


    @RequestMapping(value = "/getCartGood", method = RequestMethod.POST)
    @ResponseBody
    public String getCartGood(@RequestParam("id") Integer id,Model model){


        //新建购物车商品集合，如果存在就无需新建

        List<Goods> cartGoodList= null;
        try {
            cartGoodList = (List<Goods>) session.getAttribute("cartGoodList");
            if (null==cartGoodList){
                cartGoodList=new ArrayList<Goods>();
            }
            //根据id单查
            Goods goods=goodsImpl.getGoodByGoodId(id);
            //将单查的商品加入集合
            cartGoodList.add(goods);
            //将购物车商品集合放入Model
            model.addAttribute("cartGoodList",cartGoodList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        return gson.toJson(cartGoodList);
    }

//    @RequestMapping(value = "getCartGood.json", method = { RequestMethod.POST })
//    @ResponseBody
//    public List<Top> getCartGood(@RequestBody  Map<String, String> map){
//
//        Integer id=new Integer(map.get("goodId"));
//        System.out.println(id);
//        List<Top> cartGoodList=new ArrayList<Top>();
//
//        Top top=topService.getTopListById(id);
//
//        cartGoodList.add(top);
//
//        return cartGoodList;
//    }

}
