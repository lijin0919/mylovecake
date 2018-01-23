package com.service;


import com.entity.Items;
import com.mapper.IItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements IItemsService {
    @Autowired
    private IItemsMapper iItemsMapper;
    public Integer insertItem(Items items) {

        return iItemsMapper.insertItem(items);
    }
}
