package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.ExperienceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/experience")
    public String viewExperience(Model model) {
        model.addAttribute("experience", experienceService.getAllExperience());
        return "experience";
    }
}