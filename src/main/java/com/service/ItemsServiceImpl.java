package com.service;


import com.entity.Items;
import com.mapper.IItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements IItemsService {
    @Autowired
    private IItemsMapper iItemsMapper;

    //插入item信息
    public Integer insertItem(Items items) {

        return iItemsMapper.insertItem(items);
    }
    //根据订单id查询该订单中商品id集合
    public List<Integer> getGoodListByOrferId(Integer orderId) {
        return iItemsMapper.findGoodIdListByOrderId(orderId);
    }
}
