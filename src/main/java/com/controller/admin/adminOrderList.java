package com.controller.admin;

import com.entity.Order;
import com.google.gson.Gson;
import com.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@CrossOrigin
public class adminOrderList {
    @Autowired
    private HttpSession session;

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/orderList")
    public String orderList() {
        List<Order> orderList=orderService.getAllOrders();
        session.setAttribute("orderList",orderList);
        return "adminOrderList";
    }

    @PostMapping("/orderList1")
    @ResponseBody
    public String orderListHave(@RequestParam("status")Integer status) {
        List<Order> returnList=new ArrayList<Order>();
        List<Order> orderList=orderService.getAllOrders();
        for (Order order:orderList) {
            if (status==order.getStatus()){
                returnList.add(order);
            }
        }

        session.setAttribute("orderList",returnList);
        return new Gson().toJson(returnList);
    }
}
