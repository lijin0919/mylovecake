package com.service;

import com.entity.Types;

import java.util.List;

public interface ITypeListService {
    /**
     * 商品类型全查
     */
    List<Types> findTypeList();
}
