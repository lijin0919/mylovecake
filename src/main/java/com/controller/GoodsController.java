package com.controller;

import com.entity.Goods;
import com.entity.Types;
import com.service.GoodsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsImpl goodsImpl;

    @GetMapping("/typeGoods")
    public String say(@RequestParam("goodsTypeId") Integer goodsTypeId, Model goodModel){

        List<Goods> list=goodsImpl.getGoodsListByTypeId(new Integer(goodsTypeId));
        goodModel.addAttribute("goodsList",list);

        return "goods";
    }
}
