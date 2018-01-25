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

    public Types getTypesByTypeId(Integer typeId) {

        return iTypeMapper.findTypeById(typeId);
    }

    public Integer insertNewType(String name) {

        return iTypeMapper.insertType(name);
    }

    public Integer changeTypeNameById(String typeName,Integer typeId) {
        Integer num= iTypeMapper.changeTypeNameByTypeId(typeName,typeId);
        return num;
    }

    public Integer deleteTypeById(Integer typeId) {
        return iTypeMapper.deleteTypeById(typeId);
    }

}
