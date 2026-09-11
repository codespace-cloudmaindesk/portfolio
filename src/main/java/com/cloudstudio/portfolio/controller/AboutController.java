package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.AboutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    private final AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping("/about")
    public String viewAbout(Model model) {
        model.addAttribute("about", aboutService.getAboutContent());
        return "about";
    }
}