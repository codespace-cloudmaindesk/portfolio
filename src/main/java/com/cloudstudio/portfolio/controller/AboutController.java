package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.AboutService;
import com.cloudstudio.portfolio.service.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    private final AboutService aboutService;
    private final SkillService skillService;

    public AboutController(AboutService aboutService, SkillService skillService) {
        this.aboutService = aboutService;
        this.skillService = skillService;
    }

    @GetMapping("/about")
    public String viewAbout(Model model) {
        model.addAttribute("about", aboutService.getAboutContent());
        model.addAttribute("skills", skillService.getAllSkills());
        return "about";
    }
}