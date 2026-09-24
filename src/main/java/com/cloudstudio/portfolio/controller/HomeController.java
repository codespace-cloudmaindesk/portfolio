package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.AboutService;
import com.cloudstudio.portfolio.service.MetricService;
import com.cloudstudio.portfolio.service.RoleService;
import com.cloudstudio.portfolio.service.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final RoleService roleService;
    private final AboutService aboutService;
    private final SkillService skillService;
    private final MetricService metricService;

    public HomeController(RoleService roleService, AboutService aboutService,
                          SkillService skillService, MetricService metricService) {
        this.roleService = roleService;
        this.aboutService = aboutService;
        this.skillService = skillService;
        this.metricService = metricService;
    }

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("about", aboutService.getAboutContent());
        model.addAttribute("roleSeparator", "|");
        model.addAttribute("skills", skillService.getAllSkills());
        model.addAttribute("metrics", metricService.getAllMetrics());
        return "home";
    }
}