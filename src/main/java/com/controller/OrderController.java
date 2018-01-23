package com.controller;

import com.entity.Order;
import com.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private HttpSession session;

    @Autowired
    private OrderServiceImpl orderService;


    @GetMapping("/order")
    public String order(){
        List<Order> orderList=orderService.getAllOrders();
        session.setAttribute("orderList",orderList);
        return "order";
    }
}
