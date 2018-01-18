package com.service;

import com.entity.Top;

import java.util.List;

public interface ITopService {
//获取首页商品信息集合
  List<Top> getTopList();
  //根据id获取单个首页商品
  Top getTopListById(Integer topId);

}
