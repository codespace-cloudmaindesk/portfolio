package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.AboutService;
import com.cloudstudio.portfolio.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final RoleService roleService;
    private final AboutService aboutService;

    public HomeController(RoleService roleService, AboutService aboutService) {
        this.roleService = roleService;
        this.aboutService = aboutService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("about", aboutService.getAboutContent());
        return "home";
    }
}