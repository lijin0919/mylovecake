package com.service;

import com.entity.Types;

import java.util.List;

public interface IGoodsTypes {
    //获取所有商品类型集合
    List<Types> getGoodTypeLIst();
    //根据typeId获取type
    Types getTypesByTypeId(Integer typeId);
    //插入新的商品类目
    Integer insertNewType(String name);
    //根据typeID更新typeName
    Integer changeTypeNameById(String typeName,Integer typeId);
    //根据类型id删除类型信息
    Integer deleteTypeById(Integer typeId);
}
