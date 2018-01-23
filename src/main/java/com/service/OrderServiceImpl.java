package com.service;

import com.entity.Goods;
import com.entity.Order;
import com.mapper.IItemsMapper;
import com.mapper.IOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderMapper iOrderMapper;
    @Autowired
    private IItemsMapper iItemsMapper;
    @Autowired
    private GoodsImpl goodsImpl;
    /**
     * 插入一个订单信息
     * @param order
     * @return
     */
    public Integer insertOrder(Order order){
        Integer num=iOrderMapper.insertOrder( order.getTotal(),  order.getAmount(),  order.getStatus(),  order.getPaytype(),
                order.getName(),order.getPhone(),order.getAddress(),  order.getSystime(),  order.getUserId());

        return num;
    }

    /**
     * 查询订单的最大id
     * @return
     */
    public Integer getMaxIdOfOrder() {
        Integer maxNum=iOrderMapper.findMaxId();
        return maxNum;
    }

    /**
     * 订单全查
     * @return
     */
    public List<Order> getAllOrders() {
        List<Order> list=iOrderMapper.findAllOrders();
        try {
            for (Order order:list) {
                List<Goods> goodList=new ArrayList<Goods>();
                List<Integer> goodIdList=iItemsMapper.findGoodIdListByOrderId(order.getId());
                for (Integer goodId: goodIdList) {
                    System.out.println(goodsImpl.getGoodByGoodIdAndOrderId(order.getId(),goodId));
                    goodList.add(goodsImpl.getGoodByGoodId(goodId));

                }
                order.setGoodsList(goodList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
