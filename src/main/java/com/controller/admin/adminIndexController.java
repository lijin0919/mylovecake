package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class adminIndexController {
    /**
     * 跳转到后台管理首页
     * @return
     */
    @GetMapping("/adminIndex")
    public String adminlogin() {
        return "adminIndex";
    }
}
