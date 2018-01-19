package com.service;

import com.entity.Types;

import com.mapper.ITypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsTypesImpl implements IGoodsTypes {

    @Autowired
    private ITypeMapper iTypeMapper;

    public List<Types> getGoodTypeLIst() {

        return iTypeMapper.findTypeList();
    }
}
