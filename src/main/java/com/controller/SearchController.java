package com.controller;

import com.entity.Goods;
import com.service.GoodsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private GoodsImpl goodsService;

    @PostMapping("/search")
    public String findItemByWord(@RequestParam("name") String word, Model model){
        System.out.println("搜索的关键字："+word);
        List<Goods> goodsList = goodsService.findGoodsByLikeName(word);
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("isSearch",true);
        return "goods";
    }
}
