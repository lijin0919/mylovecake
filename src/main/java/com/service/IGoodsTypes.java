package com.service;

import com.entity.Types;

import java.util.List;

public interface IGoodsTypes {
    //获取所有商品类型集合
    List<Types> getGoodTypeLIst();
    //根据typeId获取type
    Types getTypesByTypeId(Integer typeId);
}
