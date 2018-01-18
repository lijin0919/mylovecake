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

    private Integer typeId;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Top{" +
                "types=" + types +
                ", goods=" + goods +
                ", topId=" + topId +
                ", goodId=" + goodId +
                ", typeId=" + typeId +
                '}';
    }
}
