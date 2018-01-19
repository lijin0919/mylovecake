package com.controller;

import com.entity.Goods;
import com.entity.Top;
import com.entity.Types;
import com.service.GoodsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsImpl goodsImpl;
    @Autowired
    private HttpSession session;

    @GetMapping("/typeGoods")
    public String say(@RequestParam("goodsTypeId") Integer goodsTypeId, Model goodModel){

        List<Goods> list=goodsImpl.getGoodsListByTypeId(new Integer(goodsTypeId));
        goodModel.addAttribute("goodsList",list);

        return "goods";
    }

    /**
     * 点击菜单栏热销或者新品，传递参数goodsType
     * @param goodsType
     * @param goodModel
     * @return
     */
    @GetMapping("/typeGoods2")
    public String say(@RequestParam("goodsType")String goodsType, Model goodModel){

        List<Goods> list=new ArrayList<Goods>();
//        当参数goodsType为tops时，将热销商品集合放入model
        if ("tops".equals(goodsType)){
        List<Top> listTop= (List<Top>) session.getAttribute("topList2");
        for (Top top:listTop) {
            Types types=new Types();
            types.setTypeId(111);
            types.setTypeName("热销推荐");
            top.getGoods().setGoodType(types);
            list.add(top.getGoods());
        }
        }
        //        当参数goodsType为news时，将新品推荐商品集合放入model
        if("news".equals(goodsType)){
            List<Top> listTop= (List<Top>) session.getAttribute("topList3");
            for (Top top:listTop) {
                Types types=new Types();
                types.setTypeId(112);
                types.setTypeName("新品推荐");
                top.getGoods().setGoodType(types);
                list.add(top.getGoods());
            }
        }
        goodModel.addAttribute("goodsList",list);

        return "goods";
    }

}
