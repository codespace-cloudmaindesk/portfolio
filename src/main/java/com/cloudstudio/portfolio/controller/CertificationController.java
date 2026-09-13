package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.CertificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CertificationController {

    private final CertificationService certificationService;

    public CertificationController(CertificationService certificationService) {
        this.certificationService = certificationService;
    }

    @GetMapping("/certifications")
    public String viewCertification(Model model) {
        model.addAttribute("certifications",certificationService.getAllCertification());
        return "certifications";
    }
}