package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/skills")
    public String viewSkills(Model model) {
        model.addAttribute("skills", skillService.getAllSkills());
        return "skills";
    }
}