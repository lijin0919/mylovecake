package com.service;

import com.entity.Goods;
import com.entity.Types;

import java.util.List;

public interface IGoods {
    //根据商品类型获取商品集合
   List<Goods> getGoodsListByTypeId(Integer typeId);


}
