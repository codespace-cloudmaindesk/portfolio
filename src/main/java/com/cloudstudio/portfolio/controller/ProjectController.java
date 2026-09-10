package com.cloudstudio.portfolio.controller;

import org.springframework.ui.Model;
import com.cloudstudio.portfolio.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String viewProjects(Model model){
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects";
    }
}
