package com.kb1.containerMarket.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/member")
@Controller
public class MainController {

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam @Nullable String username,
                        @RequestParam @Nullable String error) {
        model.addAttribute("username", username == null ? "" : username);
        model.addAttribute("error",error == null? "" : error);
        return "/member/login";
    }

    @GetMapping("/join")
    public String join() {
        return "/member/join";
    }

    @GetMapping("/modify")
    public String modify() {return "/member/modify";}
}
