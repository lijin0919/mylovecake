package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 购物车页面Controller
 */
@Controller
public class CartController {
    @GetMapping("/cart")
    public String say(){

        return "cart";
    }
}
