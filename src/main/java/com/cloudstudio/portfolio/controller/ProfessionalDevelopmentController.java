package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.ProfessionalDevelopmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfessionalDevelopmentController {

    private final ProfessionalDevelopmentService professionalDevelopmentService;

    public ProfessionalDevelopmentController(ProfessionalDevelopmentService professionalDevelopmentService) {
        this.professionalDevelopmentService = professionalDevelopmentService;
    }

    @GetMapping("/professionalDevelopment")
    public String viewProfessionalDevelopment(Model model) {
        model.addAttribute("professionalDevelopment", professionalDevelopmentService.getAllProfessionalDevelopment());
        return "professionalDevelopment";
    }
}