package com.mapper;

import com.entity.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface IOrderMapper {
    /**
     * 插入一个订单信息
     * @param total
     * @param amount
     * @param status
     * @param paytype
     * @param name
     * @param phone
     * @param address
     * @param systime
     * @param userId
     * @return
     */
    @Insert("INSERT INTO orders(total,amount,status,paytype,name,phone,address,systime,user_id) VALUES(#{total},#{amount},#{status},#{paytype},#{name},#{phone},#{address},#{systime},#{userId});")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "total",column = "total"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "status",column = "status"),
            @Result(property = "paytype",column = "paytype"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "address",column = "address"),
            @Result(property = "systime",column = "systime"),
            @Result(property = "userId",column = "user_id")
    })
    Integer insertOrder(@Param("total") Integer total, @Param("amount")Integer amount, @Param("status")byte status,@Param("paytype") byte paytype, @Param("name")String name, @Param("phone")String phone, @Param("address")String address, @Param("systime")Timestamp systime, @Param("userId")Integer userId);

    /**
     * 查询订单id的最大值
     * @return
     */
    @Select("SELECT MAX(id) FROM orders;")
    Integer findMaxId();


    /**
     * 订单全查
     */
    @Select("SELECT * FROM orders;")
    List<Order> findAllOrders();

    /**
     * 将订单状态改为已完成
     * @param id
     * @return
     */
    @Update("UPDATE orders SET status=4 WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id")
    })
    Integer orderConfirm(@Param("id") Integer id);

    /**
     * 将订单状态改为已付款
     * @param id
     * @return
     */
    @Update("UPDATE orders SET status=2 WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id")
    })
    Integer orderPay(@Param("id") Integer id);
    /**
     * 将订单状态改为正在配送
     * @param id
     * @return
     */
    @Update("UPDATE orders SET status=3 WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id")
    })
    Integer orderOnExpress(@Param("id") Integer id);

    @Select("SELECT status FROM orders WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "status",column = "status")
    })
    Integer findOrderStatusByOrderId(Integer id);
}
