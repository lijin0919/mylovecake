package com.mapper;

import com.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static org.apache.ibatis.type.JdbcType.VARCHAR;

/**
 * 商品表映射
 */
@Mapper
public interface IGoodMapper {

    /**
     * 根据商品id查商品
     * @param id
     * @return
     */

    @Select("SELECT * FROM goods WHERE id=#{id};")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name"),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    Goods findGoodById(Integer id);


    /**
     * 商品全查
     * @return
     */
    @Select("SELECT * FROM goods;")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name"),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    List<Goods> findGoodList();


    /**
     * 根据商品类型id查询商品
     *
     */
    @Select("SELECT * FROM goods WHERE type_id=#{Id};")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name"),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    List<Goods> findGoodListByTypeId(Integer Id);

    /**
     * 搜索模糊查询
     * @param name
     * @return
     */
    @Select("SELECT * FROM goods WHERE name LIKE CONCAT('%',#{name},'%') ")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name", jdbcType=VARCHAR),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    List<Goods> findGoodListByLikeName(@Param("name") String name);

    /**
     * 查询商品总数
     * @return
     */
    @Select("SELECT count(*) FROM goods;")
    Integer findTotalNumOfGoods();

    /**
     * 根据当前页和每页商品数量查询商品集合
     * @param currentPage
     * @param goodsNum
     * @return
     */
    @Select("SELECT * FROM goods WHERE 1=1 LIMIT #{currentPage},#{goodsNum}")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name", jdbcType=VARCHAR),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    List<Goods> findGoodsListForPage(@Param("currentPage") Integer currentPage,@Param("goodsNum")Integer goodsNum);

    /**
     * 根据商品id删除商品信息
     * @param goodId
     * @return
     */
    @Delete("DELETE FROM goods WHERE id=#{goodId}")
    @Results({
            @Result(id = true,property = "goodId",column = "id")
    })
    Integer deleteGoodByGoodId(@Param("goodId") Integer goodId);

    /**
     * 插入一条新商品
     * @param goods
     * @return
     */
    @Insert("INSERT INTO goods(name,cover,image1,image2,price,intro,stock,type_id)" +
            " VALUES(#{goodName},#{goodCover},#{goodImage1},#{goodImage2},#{goodPrice},#{goodIntro},#{goodStock},#{typeId})")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name", jdbcType=VARCHAR),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    Integer  insertGood(Goods goods);

    /**
     * 修改，更新商品信息
     * @param goods
     * @return
     */
    @Update("UPDATE goods SET name=#{goodName},price=#{goodPrice},intro=#{goodIntro},stock=#{goodStock}," +
            "cover=#{goodCover},image1=#{goodImage1},image2=#{goodImage2},type_id=#{typeId} WHERE 1=1 AND id=#{goodId};")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name", jdbcType=VARCHAR),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    Integer updateGood(Goods goods);
}
