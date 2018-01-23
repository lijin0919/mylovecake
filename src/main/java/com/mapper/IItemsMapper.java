package com.mapper;

import com.entity.Items;
import org.apache.ibatis.annotations.*;

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


    //根据商品id和订单id查询商品数量
    @Select("SELECT amount FROM items WHERE order_id=#{orderId} AND good_id=#{goodId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "price",column = "price"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "orderId",column = "order_id"),
            @Result(property = "goodId",column = "good_id")
    })
    Integer findAmountByGoodIdAndOrderId(@Param("orderId")Integer orderId,@Param("goodId")Integer goodId);
}
