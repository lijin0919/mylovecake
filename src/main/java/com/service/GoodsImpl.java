package com.service;

import com.entity.Goods;
import com.entity.Types;
import com.mapper.IGoodMapper;
import com.mapper.ITypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsImpl implements IGoods {
    @Autowired
    private IGoodMapper goodMapper;
    @Autowired
    private ITypeMapper iTypeMapper;
    public List<Goods> getGoodsListByTypeId(Integer Id) {
        System.out.println(Id+"*****************************************************************");
        List<Goods> goodslist=goodMapper.findGoodListByTypeId(Id);

        System.out.println(goodslist);
        for (Goods good:goodslist) {
            good.setGoodType(iTypeMapper.findTypeById(good.getTypeId()));
        }
        return goodslist;
    }


}
