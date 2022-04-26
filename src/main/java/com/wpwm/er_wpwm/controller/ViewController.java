package com.wpwm.er_wpwm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
