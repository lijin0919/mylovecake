package com.service;

import com.entity.Top;
import com.entity.Types;
import com.mapper.IGoodMapper;
import com.mapper.ITopMapper;
import com.mapper.ITypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopServiceImpl implements ITopService{

    @Autowired
    private ITopMapper topMapper;
    @Autowired
    private ITypeMapper typeMapper;
    @Autowired
    private IGoodMapper goodMapper;
    @Autowired
    private ITypeMapper iTypeMapper;
    //获取tops集合
    public List<Top> getTopList() {

        //获取top信息
        List<Top> topList = topMapper.findTopList();
        // 遍历tops集合
        for (Top top: topList
                ) {
            int goodId = top.getGoodId();
            int typeId = top.getTypeId();
            top.setTypes(typeMapper.findTypeById(typeId));
            top.setGoods(goodMapper.findGoodById(goodId));

        }


        return topList;
    }


    public List<Top> getTopListByTypeId(Integer typeId) {
        List<Top> topList = topMapper.findTopListByTypeId(typeId);
        // 遍历tops集合
        for (Top top: topList
                ) {
            int goodId = top.getGoodId();
            top.setTypes(typeMapper.findTypeById(typeId));
            top.setGoods(goodMapper.findGoodById(goodId));
        }
        return topList;
    }

    public Integer insertTop(Integer goodId, Integer typeId) {
            Integer num=topMapper.insertTop(goodId,typeId);
        return num;
    }



    public Top getTopListById(Integer topId) {
        Top top = topMapper.findTopListById(topId);
        return top;
    }

    public List<Top> getTopList(Integer typeId) {
        //获取top信息
        List<Top> topList = topMapper.findTopListByTypeId(typeId);
        for (Top top: topList
                ) {
            int goodId = top.getGoodId();

            top.setTypes(typeMapper.findTypeById(typeId));
            top.setGoods(goodMapper.findGoodById(goodId));
        }
        return topList;
    }

    public Integer deleteTopByGoodIdAndType(Integer goodId, Integer typeId) {

        return topMapper.deleteTopByGoodIdAndType(goodId,typeId);
    }
}
