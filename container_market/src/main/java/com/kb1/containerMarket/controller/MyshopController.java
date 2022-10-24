package com.kb1.containerMarket.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myshop")
public class MyshopController {

    @GetMapping("/index")
    public String index(){
        return "/myshop/index";
    }

    @GetMapping("/order/list")
    public String orderList(){return "/myshop/order/list";}
}
