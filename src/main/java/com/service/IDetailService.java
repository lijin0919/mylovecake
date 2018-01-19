package com.service;

import com.entity.Goods;

public interface IDetailService {
    /**
     * 通过goodId获取商品
     * @return
     */
    Goods findGoodByGoodId(Integer goodId);
}
