package com.msecurity03.home;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class HomeController {
    @GetMapping("/")
    public String Home(Model model){
        model.addAttribute("title", "메인 페이지");
        model.addAttribute("msg", "스프링부트 시큐리티");
        return "index";
    }
}
