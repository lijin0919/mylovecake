package com.controller;

import com.entity.*;
import com.service.ItemsServiceImpl;
import com.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;

/**
 * 支付页面controller
 */
@Controller
public class TopayController {

    @Autowired
    private HttpSession session;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private ItemsServiceImpl itemsService;
    @GetMapping("/topay")
    public String topay() throws ParseException {
        //session中获取购物车商品信息
        Cart cart= (Cart) session.getAttribute("cart");
        //session中获取用户信息
        Users user= (Users) session.getAttribute("user");
        //实例化一个表单对象，并给属性赋值
        Order order=new Order();
        order.setTotal(cart.getTotalPricr());
        order.setAmount(cart.getTotalNum());
        order.setStatus((byte) 1);
        order.setPaytype((byte) 1);
        order.setName(user.getName());
        order.setPhone(user.getUserPhone());
        order.setAddress(user.getUserAddress());
        order.setUserId(user.getId());
        Integer num=orderService.insertOrder(order);
        //获取本次订单id并给order对象赋值
        Integer maxId=orderService.getMaxIdOfOrder();
        order.setId(maxId);
        session.setAttribute("order",order);
        //--------------------给items插入信息--------------------
        for (Goods good:cart.getGoodsList()) {
            itemsService.insertItem(new Items(0,good.getGoodPrice(),good.getGoodsNum(),maxId,good.getGoodId()));
        }
        session.removeAttribute("cart");
        return "topay";
    }
}
