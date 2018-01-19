package com.service;

import com.entity.Types;
import com.mapper.ITypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeListImpl implements ITypeListService {
    @Autowired
    private ITypeMapper typeMapper;
    public List<Types> findTypeList() {
        //获取typeList
        List<Types> typesList = typeMapper.findTypeList();

        return typesList;
    }
}
