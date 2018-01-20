package com.controller;

import com.entity.Cart;
import com.entity.Goods;
import com.entity.Top;
import com.entity.Types;
import com.google.gson.Gson;
import com.service.GoodsImpl;
import com.service.GoodsTypesImpl;
import com.service.TopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
//@SessionAttributes({"typeList","topList1","topList2","topList3","cart"})
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
            session.setAttribute("topList1",topList1);
            List<Top> topList2 = topService.getTopListByTypeId(2);
            session.setAttribute("topList2",topList2);
            List<Top> topList3 = topService.getTopListByTypeId(3);
            session.setAttribute("topList3",topList3);
            List<Types> typeList=goodsTypes.getGoodTypeLIst();
            session.setAttribute("typeList",typeList);
//            System.out.println(topList1);

        }catch (Exception e){
            e.printStackTrace();
        }

     return "index";
    }


    @RequestMapping(value = "/getCartGood", method = RequestMethod.POST)
    @ResponseBody
    public String getCartGood(@RequestParam("id") Integer id){


        //新建购物车商品集合，如果存在就无需新建
        boolean flag=false;
        boolean flag1=false;
        Cart cart= null;
        try {
            cart = (Cart) session.getAttribute("cart");
            if (null==cart){
                cart=new Cart();
                cart.setTotalNum(0);
                cart.setTotalPricr(0);
                flag=true;

            }
            //根据id单查

            Goods goods=goodsImpl.getGoodByGoodId(id);
            //设置商品数量为1
            goods.setGoodsNum(1);
            //将单查的商品加入cart中的商品集合
//            System.out.println(goods);
            if (flag){
                List<Goods> list=new ArrayList<Goods>();
                list.add(goods);
                cart.setGoodsList(list);
            }else {
                for (Goods goods1:cart.getGoodsList()) {
                    if (id.equals(goods.getGoodId())){
                        goods1.setGoodsNum(goods1.getGoodsNum()+1);
                        flag1=true;
                    }
                }
            }
            //遍历购物车类中商品集合，算出商品总价和商品总数
                if (!flag1){
                cart.getGoodsList().add(goods);
                }
                cart.setTotalNum(cart.getTotalNum()+goods.getGoodsNum());
                cart.setTotalPricr(cart.getTotalPricr()+goods.getGoodPrice()*goods.getGoodsNum());

            //将购物车实例
//            System.out.println(cart);
            session.setAttribute("cart",cart);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        return gson.toJson(cart);
    }

//    @RequestMapping(value = "/AddCartGood", method = RequestMethod.POST)
//    @ResponseBody
//    public String addCartGood(@RequestParam("id") Integer id,Model model){
//
//
//        //新建购物车商品集合，如果存在就无需新建
//        boolean flag=false;
//        Cart cart= null;
//        try {
//            cart = (Cart) session.getAttribute("cart");
//
//            //遍历购物车类中商品集合，算出商品总价和商品总数
//            //给对应商品id的商品数量加1
//            for (Goods good:cart.getGoodsList()) {
//                if(id.equals(good.getGoodId())){
//                    good.setGoodsNum(good.getGoodsNum()+1);
//                    cart.setTotalNum(cart.getTotalNum()+1);
//                    cart.setTotalPricr(cart.getTotalPricr()+good.getGoodPrice());
//                }
//            }
//            //将购物车实例
//            model.addAttribute("cart",cart);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Gson gson = new Gson();
//
//        return gson.toJson(cart);
//    }

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
