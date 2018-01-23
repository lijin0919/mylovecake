package com.service;

import com.entity.Order;

import java.util.List;


public interface IOrderService {
    //插入订单信息
    Integer insertOrder(Order order);
    //查询订单的最大id
    Integer getMaxIdOfOrder();
    //订单全查
    List<Order> getAllOrders();
}
