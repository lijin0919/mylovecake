package com.controller;

import com.entity.Cart;
import com.entity.Goods;
import com.google.gson.Gson;
import com.service.GoodsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车页面Controller
 */
@Controller
@CrossOrigin
public class CartController {

    @Autowired
    private GoodsImpl goodsImpl;

    @Autowired
    private HttpSession session;

    @GetMapping("/cart")
    public String addGood() {
        return "cart";
    }

    @PostMapping("/addGood")
    @ResponseBody
    public String cart(@RequestParam("id") Integer id) {
        Cart cart = null;
        List<Integer> list=new ArrayList<Integer>();
        Integer goodNum=0;
        Integer totalPrice=0;
        Integer totalNum=0;

        try {
            cart = (Cart) session.getAttribute("cart");
            for (Goods good : cart.getGoodsList()) {
                if (good.getGoodId()==id) {

                    good.setGoodsNum(good.getGoodsNum() + 1);
                    goodNum=good.getGoodsNum();
                    cart.setTotalNum(cart.getTotalNum() + 1);
                    totalNum=cart.getTotalNum();
                    cart.setTotalPricr(cart.getTotalPricr() + good.getGoodPrice());
                    totalPrice=cart.getTotalPricr();
                    break;
                }
            }
            session.setAttribute("cart", cart);
            list.add(goodNum);
            list.add(totalNum);
            list.add(totalPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(list);

    }



    @PostMapping("/decGood")
    @ResponseBody
    public String decGood(@RequestParam("id") Integer id) {
        List<Integer> list=new ArrayList<Integer>();
        Integer goodNum=0;
        Integer totalPrice=0;
        Integer totalNum=0;
        Cart cart = null;
        try {
            cart = (Cart) session.getAttribute("cart");
            for (Goods good : cart.getGoodsList()) {
                if (good.getGoodId()==id) {
                    if (good.getGoodsNum()>1) {
                        good.setGoodsNum(good.getGoodsNum() - 1);
                        goodNum=good.getGoodsNum();
                        cart.setTotalNum(cart.getTotalNum() - 1);
                        totalNum=cart.getTotalNum();
                        cart.setTotalPricr(cart.getTotalPricr() - good.getGoodPrice());
                        totalPrice=cart.getTotalPricr();
                        break;
                    }
                }
            }
            session.setAttribute("cart", cart);
            list.add(goodNum);
            list.add(totalNum);
            list.add(totalPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @PostMapping("/deleteGood")
    @ResponseBody
    public String deleteGood(@RequestParam("id") Integer id) {
        Cart cart = null;
        List<Integer> list=new ArrayList<Integer>();
        Integer goodNum=0;
        Integer totalPrice=0;
        Integer totalNum=0;
        try {
            cart = (Cart) session.getAttribute("cart");
            for (Goods good : cart.getGoodsList()) {
                if (good.getGoodId()==id) {
                    cart.getGoodsList().remove(good);
                    cart.setTotalNum(cart.getTotalNum()-good.getGoodsNum());
                    totalNum=cart.getTotalNum();
                    cart.setTotalPricr(cart.getTotalPricr()-good.getGoodsNum()*good.getGoodPrice());
                    totalPrice=cart.getTotalPricr();
                    break;
                }
            }
            session.setAttribute("cart", cart);
            list.add(goodNum);
            list.add(totalNum);
            list.add(totalPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
