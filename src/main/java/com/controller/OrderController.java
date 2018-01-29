package com.controller;

import com.entity.Order;
import com.google.gson.Gson;
import com.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private HttpSession session;

    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 跳转到订单页面
     * @return
     */
    @GetMapping("/order")
    public String order(){
        List<Order> orderList=orderService.getAllOrders();
        session.setAttribute("orderList",orderList);
        return "order";
    }

    /**
     * 已收货订单的映射
     * @param id
     * @return
     */
    @PostMapping ("/receiveGoods")
    @ResponseBody
    public String receiveGoods(@RequestParam("id")Integer id){
        Integer num=orderService.receiveGoods(id);

        return new Gson().toJson(num);
    }

    /**
     * 已付款订单的映射
     * @param id
     * @return
     */
    @PostMapping ("/toPayNow")
    @ResponseBody
    public String toPayNow(@RequestParam("id")Integer id){
        Integer num=orderService.orderPay(id);

        return new Gson().toJson(num);
    }

    /**
     * 删除订单的映射
     * @param id
     * @return
     */
    @PostMapping("/deleteOrder")
    @ResponseBody
    public String deleteOrder(@RequestParam("id")Integer id){
        Integer num =orderService.deleteOrderByOrderId(id);
        return new Gson().toJson(num);
    }
}
