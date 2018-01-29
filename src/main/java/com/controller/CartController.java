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

    /**
     * 跳转到购物车页面
     * @return
     */
    @GetMapping("/cart")
    public String addGood() {
        return "cart";
    }

    /**
     * 迷你购物车中某个商品数量增加1
     * @param id
     * @return
     */
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

    /**
     * 迷你购物车中某个商品数量减少1
     * @param id
     * @return
     */

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
                    }else {
                        goodNum=good.getGoodsNum();
                        totalNum=cart.getTotalNum();
                        totalPrice=cart.getTotalPricr();
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

    /**
     * 删除迷你购物车中某个商品
     * @param id
     * @return
     */
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

    /**
     * 购物车页面内每次点击某个商品的增加按钮，商品数量数量增加1个,并且重新计算总价
     * @param id
     * @return
     */
    @PostMapping("/addGood2")
    @ResponseBody
    public String addGood2(@RequestParam("id") Integer id) {
        Cart cart = null;

        try {
            cart = (Cart) session.getAttribute("cart");
            for (Goods good : cart.getGoodsList()) {
                if (good.getGoodId()==id) {

                    good.setGoodsNum(good.getGoodsNum() + 1);
                    cart.setTotalNum(cart.getTotalNum() + 1);
                    cart.setTotalPricr(cart.getTotalPricr() + good.getGoodPrice());
                    break;
                }
            }
            session.setAttribute("cart", cart);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(cart);

    }

    /**
     * 购物车页面内每次点击某个商品的减少按钮，商品数量数量减少1个,并且重新计算总价
     * @param id
     * @return
     */
    @PostMapping("/decGood2")
    @ResponseBody
    public String decGood2(@RequestParam("id") Integer id) {

        Cart cart = null;
        try {
            cart = (Cart) session.getAttribute("cart");
            for (Goods good : cart.getGoodsList()) {
                if (good.getGoodId()==id) {
                    if (good.getGoodsNum()>1) {
                        good.setGoodsNum(good.getGoodsNum() - 1);
                        cart.setTotalNum(cart.getTotalNum() - 1);
                        cart.setTotalPricr(cart.getTotalPricr() - good.getGoodPrice());
                        break;
                    }
                }
            }
            session.setAttribute("cart", cart);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(cart);
    }
    /**
     * 购物车页面内每次点击某个商品的删除按钮，则将此商品移除,并且重新计算总价
     */
    @PostMapping("/deleteGood2")
    @ResponseBody
    public String deleteGood2(@RequestParam("id") Integer id) {
        Cart cart = null;

        try {
            cart = (Cart) session.getAttribute("cart");
            for (Goods good : cart.getGoodsList()) {
                if (good.getGoodId()==id) {
                    cart.getGoodsList().remove(good);
                    cart.setTotalNum(cart.getTotalNum()-good.getGoodsNum());
                    cart.setTotalPricr(cart.getTotalPricr()-good.getGoodsNum()*good.getGoodPrice());
                    break;
                }
            }
            session.setAttribute("cart", cart);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(cart);
    }
}
