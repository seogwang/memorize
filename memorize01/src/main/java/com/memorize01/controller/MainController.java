package com.memorize01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "에듀테크");
        model.addAttribute("msg", "스프링부트 프로젝트");
        return "index";
    }
}
