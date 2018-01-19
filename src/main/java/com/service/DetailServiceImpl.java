package com.service;

import com.entity.Goods;
import com.entity.Types;
import com.mapper.IGoodMapper;
import com.mapper.ITypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements IDetailService {
    @Autowired
    private IGoodMapper iGoodMapper;
    @Autowired
    private ITypeMapper iTypeMapper;
    public Goods findGoodByGoodId(Integer goodId) {
        //通过goodId数据库查询good信息
        Goods good = iGoodMapper.findGoodById(goodId);
        //得到typeId
        Integer typeId = good.getTypeId();
        //根据typeId获取goodType
        Types goodType = iTypeMapper.findTypeById(typeId);
        //为good对象添加goodType属性值
        good.setGoodType(goodType);
        return good;
    }
}
