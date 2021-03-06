package com.service;

import com.entity.Items;

import java.util.List;

public interface IItemsService {
    //插入item信息
    Integer insertItem(Items items);
    //根据订单id查询该订单中商品id集合
    List<Integer> getGoodListByOrferId(Integer orderId);
    //根据商品id和订单id查询商品数量
    Integer getGoodsNumByGoodIdAndOrderId(Integer orderId, Integer goodId);
}
