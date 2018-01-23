package com.mapper;

import com.entity.Items;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IItemsMapper {
    @Insert("INSERT INTO items(price,amount,order_id,good_id) VALUES(#{price},#{amount},#{orderId},#{goodId})")
    Integer insertItem(Items items);

}
