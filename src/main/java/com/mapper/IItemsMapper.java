package com.mapper;

import com.entity.Items;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IItemsMapper {
    /**
     * 插入items
     *
     * @param items
     * @return
     */

    @Insert("INSERT INTO items(price,amount,order_id,good_id) VALUES(#{price},#{amount},#{orderId},#{goodId})")
    Integer insertItem(Items items);

    /**
     * 根据订单id查询该订单中商品id集合
     * @return
     */
    @Select("SELECT good_id FROM items WHERE order_id=#{orderId};")
    List<Integer> findGoodIdListByOrderId(Integer orderId);
}
