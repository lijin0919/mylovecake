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
        }catch (Exception e){
            e.printStackTrace();
        }
     return "index";
    }


    @RequestMapping(value = "/getCartGood", method = RequestMethod.POST)
    @ResponseBody
    public String getCartGood(@RequestParam("id") Integer id){


        //新建购物车商品集合，如果存在就无需新建
        boolean flag=true;
        Cart cart= null;
        try {
            cart = (Cart) session.getAttribute("cart");
            //根据id单查
            Goods goods=goodsImpl.getGoodByGoodId(id);
            //设置商品数量为1
            goods.setGoodsNum(1);
            if (null==cart){
                cart=new Cart();
                cart.setTotalNum(0);
                cart.setTotalPricr(0);
                List<Goods> list=new ArrayList<Goods>();
                list.add(goods);
                cart.setGoodsList(list);
            }else{
                for (Goods good:cart.getGoodsList()) {
                    if (good.getGoodId().equals(id)){
                        flag=false;
                        good.setGoodsNum(good.getGoodsNum()+goods.getGoodsNum());
                    }
                }
                if(flag){
                    cart.getGoodsList().add(goods);
                }
            }
            //将单查的商品加入cart中的商品集合
                cart.setTotalNum(cart.getTotalNum()+goods.getGoodsNum());
                cart.setTotalPricr(cart.getTotalPricr()+goods.getGoodPrice()*goods.getGoodsNum());
            session.setAttribute("cart",cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(cart);
    }

    /**
     * 点击迷你购物车中“+”号，商品数量加一
     * @param id
     * @return
     */
    @RequestMapping(value = "/addCartGood", method = RequestMethod.POST)
    @ResponseBody
    public String addCartGood(@RequestParam("id") Integer id){


        //获取购物车商品
        Cart cart = (Cart) session.getAttribute("cart");
        try {
            //遍历goods集合找到与该id对应的商品，给其数量加一，并改变商品总数和总价钱
                for (Goods good:cart.getGoodsList()) {
                    if (good.getGoodId().equals(id)){
                        good.setGoodsNum(good.getGoodsNum()+1);
                        cart.setTotalNum(cart.getTotalNum()+1);
                        cart.setTotalPricr(cart.getTotalPricr()+good.getGoodPrice());
                    }
            }

//            将购物车放入session
            session.setAttribute("cart",cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(cart);
    }

    /**
     * 点击迷你购物车中“-”号，商品数量减一
     * @param id
     * @return
     */
    @RequestMapping(value = "/decCartGood", method = RequestMethod.POST)
    @ResponseBody
    public String decCartGood(@RequestParam("id") Integer id){


        //获取购物车商品
        Cart cart = (Cart) session.getAttribute("cart");
        try {
            //遍历goods集合找到与该id对应的商品，只有当商品数量大于1时，给其数量减一，并改变商品总数和总价钱
            for (Goods good:cart.getGoodsList()) {
                if (good.getGoodId().equals(id)){
                    if ((good.getGoodsNum()-1)!=0){
                        good.setGoodsNum(good.getGoodsNum()-1);
                        cart.setTotalNum(cart.getTotalNum() - 1);
                        cart.setTotalPricr(cart.getTotalPricr() - good.getGoodPrice());
                    }
                }
            }

//            将购物车放入session
            session.setAttribute("cart",cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(cart);
    }
    @RequestMapping(value = "/deleteCartGood", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCartGood(@RequestParam("id") Integer id){

        boolean flag=false;
        //获取购物车商品
        Cart cart = (Cart) session.getAttribute("cart");
        try {
            //遍历goods集合找到与该id对应的商品，从商品总数中减去该商品数量，从商品总价总减去该商品总价，然后删除该商品

            for (int i=cart.getGoodsList().size()-1;i>=0;i--) {
                if (cart.getGoodsList().get(i).getGoodId().equals(id)){
                    System.out.println(cart.getGoodsList().size()+"-----------------------");
                    cart.setTotalNum(cart.getTotalNum()-cart.getGoodsList().get(i).getGoodsNum());
                    cart.setTotalPricr(cart.getTotalPricr()-cart.getGoodsList().get(i).getGoodPrice()*cart.getGoodsList().get(i).getGoodsNum());
                    cart.getGoodsList().remove(cart.getGoodsList().get(i));
                }
            }
            session.removeAttribute("cart");
//            将购物车放入session
            session.setAttribute("cart",cart);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(cart);
    }

    @RequestMapping(value = "/reload", method = RequestMethod.POST)
    @ResponseBody
    public String reload(){
        //新建购物车商品集合，如果存在就无需新建
        boolean flag=true;
        Cart cart= null;
        try {
            cart = (Cart) session.getAttribute("cart");

            if (null==cart){
                cart=new Cart();
                cart.setTotalNum(0);
                cart.setTotalPricr(0);
                List<Goods> list=new ArrayList<Goods>();
                cart.setGoodsList(list);
            }
            //将单查的商品加入cart中的商品集合
            session.setAttribute("cart",cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(cart);
    }
}
