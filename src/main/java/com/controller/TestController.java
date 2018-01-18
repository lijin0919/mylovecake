package com.controller;

import com.entity.Types;
import com.mapper.IIndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private IIndexMapper mapper;


    @GetMapping("/test")
    public String test(){
        try{
            List<Types> typesList = mapper.selectTypes();
            System.out.println(typesList);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "test";
    }
}
