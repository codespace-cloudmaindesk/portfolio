package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.EducationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/education")
    public String viewEducation(Model model) {
        model.addAttribute("education", educationService.getAllEducation());
        return "education";
    }
}