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
    //确认收货
    Integer receiveGoods(Integer id);
    //已付款
    Integer orderPay(Integer id);
    //根据订单id查询订单状态
    Integer getOrderStatusByOrderId(Integer id);
    //根据订单id删除订单
    Integer deleteOrderByOrderId(Integer id);
}
