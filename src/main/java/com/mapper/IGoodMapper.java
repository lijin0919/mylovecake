package com.mapper;

import com.entity.Goods;

import java.util.List;

/**
 * 商品表映射
 */
public interface IGoodMapper {
    /**
     * 根据商品id查商品
     * @param id
     * @return
     */
    Goods findGoodById(Integer id);

    List<Goods> findGoodList();
}
