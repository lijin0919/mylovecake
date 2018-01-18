package com.service;

import com.entity.Top;
import com.mapper.IGoodMapper;
import com.mapper.ITopMapper;
import com.mapper.ITypeMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TopServiceImpl implements ITopService{

    @Autowired
    private ITopMapper topMapper;
    @Autowired
    private ITypeMapper typeMapper;
    @Autowired
    private IGoodMapper goodMapper;
    //获取tops集合
    public List<Top> getTopList() {

        //获取top信息
        List<Top> topList = topMapper.findTopList();
        // 遍历tops集合
        for (Top top: topList
             ) {
            int goodId = top.getGoodId();
            int typeId = top.getTopId();
            top.setTypes(typeMapper.findTypeById(typeId));
            top.setGoods(goodMapper.findGoodById(goodId));
        }

        return topList;
    }

    public Top getTopListById(Integer topId) {
        Top top = topMapper.findTopListById(topId);
        return top;
    }
}
