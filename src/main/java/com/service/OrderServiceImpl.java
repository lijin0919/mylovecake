package com.service;

import com.entity.Order;
import com.mapper.IOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderMapper iOrderMapper;
    public Integer insertOrder(Order order){
        Integer num=iOrderMapper.insertOrder( order.getTotal(),  order.getAmount(),  order.getStatus(),  order.getPaytype(),
                order.getName(),order.getPhone(),order.getAddress(),  order.getSystime(),  order.getUserId());

        return num;
    }

    public Integer getMaxIdOfOrder() {
        Integer maxNum=iOrderMapper.findMaxId();
        return maxNum;
    }
}
