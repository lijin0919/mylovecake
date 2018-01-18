package com.controller;

import com.entity.Top;
import com.entity.Types;
import com.mapper.IIndexMapper;
import com.mapper.ITopMapper;
import com.service.ITopService;
import com.service.TopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("typeList")
public class IndexController {


    ITopService topService =new TopServiceImpl();

    @GetMapping("/index")
    public String getTypes(Model model,Model model1){

        try {
            //进行查询
            List<Top> topList = topService.getTopList();
            model.addAttribute("topList",topList);

        }catch (Exception e){
            e.printStackTrace();
        }

     return "index";
    }

}
