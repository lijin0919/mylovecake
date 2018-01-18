package com.mapper;

import com.entity.Top;

import java.util.List;

/**
 * top表映射
 */
public interface ITopMapper {
    /**
     * 根据topid查询top类型
     * @param id
     * @return
     */
    Top findTopById(Integer id);

    /**
     * 查询首页要显示的所有商品
     * @return
     */
    List<Top> findTopList();
}
