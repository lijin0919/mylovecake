package com.service;

import com.entity.Goods;
import com.entity.Types;
import com.mapper.IGoodMapper;
import com.mapper.IItemsMapper;
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
    @Autowired
    private IItemsMapper iItemsMapper;
    @Autowired
    private ItemsServiceImpl itemsService;
    /**
     * 根据商品类型id查询商品信息
     * @param Id
     * @return
     */
    public List<Goods> getGoodsListByTypeId(Integer Id) {
        List<Goods> goodslist=goodMapper.findGoodListByTypeId(Id);

        for (Goods good:goodslist) {
            good.setGoodType(iTypeMapper.findTypeById(good.getTypeId()));


        }
        return goodslist;
    }

    public List<Goods> findGoodsByLikeName(String name) {
        List<Goods> goodsList = goodMapper.findGoodListByLikeName(name);
        System.out.println("查询到的商品："+goodsList);
        return goodsList;
    }

    /**
     * 根据商品id查询商品信息
     * @param Id
     * @return
     */
    public Goods getGoodByGoodId(Integer Id){
        Goods goods=goodMapper.findGoodById(Id);
        goods.setGoodsNum(0);
        goods.setGoodType(iTypeMapper.findTypeById(goods.getTypeId()));
        return goods;
    }

    public Goods getGoodByGoodIdAndOrderId(Integer orderId, Integer goodId) {
        Goods goods=goodMapper.findGoodById(goodId);
        System.out.println(orderId+"...."+goodId);
        goods.setGoodsNum(iItemsMapper.findAmountByGoodIdAndOrderId(orderId,goodId));
        goods.setGoodType(iTypeMapper.findTypeById(goods.getTypeId()));
        return goods;
    }


}
