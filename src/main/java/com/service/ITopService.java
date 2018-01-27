package com.service;

import com.entity.Top;

import java.util.List;

public interface ITopService {
//获取首页商品信息集合
  List<Top> getTopList();
  //根据id获取单个首页商品
  Top getTopListById(Integer topId);
//根据typeId获取top类型
  List<Top> getTopListByTypeId(Integer typeId);
  //插入top信息
  Integer insertTop(Integer goodId,Integer typeId);
  //根据商品id和类型id删除top信息
    Integer deleteTopByGoodIdAndType(Integer goodId,Integer typeId);

}
