package com.entity;

/**
 * 首页商品推荐，记住，是一个商品
 */
public class Top {

    /**
     * 商品类型
     */
    private Types types;
    /**
     * 商品类型
     */
    private Goods goods;

    private Integer topId;

    private Integer goodId;
//


    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getTopId() {
        return topId;
    }

    public void setTopId(Integer topId) {
        this.topId = topId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }


}
