package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 支付页面controller
 */
@Controller
public class TopayController {
    @GetMapping("/topay")
    public String say(){
        return "topay";
    }
}
