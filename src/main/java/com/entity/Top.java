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

    @Override
    public String toString() {
        return "Top{" +
                "types=" + types +
                ", goods=" + goods +
                '}';
    }

    public Top(Types types, Goods goods) {
        this.types = types;
        this.goods = goods;
    }

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
}
