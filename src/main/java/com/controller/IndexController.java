package com.controller;

import com.entity.Types;
import com.mapper.ITypesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("typeList")
public class IndexController {
    @Autowired
    private ITypesMapper iTypesMapper;

    @GetMapping("/index")
    public String getTypes(Model model){

        try {
            //进行查询
            List<Types> typesList = iTypesMapper.selectTypes();
            model.addAttribute("types",typesList);

        }catch (Exception e){
            e.printStackTrace();
        }

     return "index";
    }

}
