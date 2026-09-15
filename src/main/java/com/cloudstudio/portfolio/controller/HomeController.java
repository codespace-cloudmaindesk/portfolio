package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.AboutService;
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

    public HomeController(RoleService roleService, AboutService aboutService, SkillService skillService) {
        this.roleService = roleService;
        this.aboutService = aboutService;
        this.skillService = skillService;
    }

    @GetMapping
    public String viewHomePage(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("about", aboutService.getAboutContent());
        model.addAttribute("roleSeparator", "|");
        model.addAttribute("skills", skillService.getAllSkills());
        return "home";
    }
}