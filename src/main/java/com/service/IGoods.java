package com.service;

import com.entity.Goods;
import com.entity.Types;

import java.util.List;

public interface IGoods {
    //根据商品类型获取商品集合
   List<Goods> getGoodsListByTypeId(Integer typeId);


   List<Goods> findGoodsByLikeName(String name);

    Goods getGoodByGoodId(Integer Id);

    Goods getGoodByGoodIdAndOrderId(Integer orderId,Integer goodId);

    Integer getGoodsTotalNum();

    //根据当前页和每页商品数量查询商品集合
    List<Goods> getGoodListByCurrentPagAndGoodsNum(Integer currentPage,Integer goodsNum );
}
