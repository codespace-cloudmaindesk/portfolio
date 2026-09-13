package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.entity.Project;
import com.cloudstudio.portfolio.entity.ProjectStatus;
import com.cloudstudio.portfolio.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProjectRepository projectRepository;

    public DataSeeder(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) {
        if (projectRepository.count() == 0) {
            Project placeholder = new Project();
            placeholder.setTitle("[PLACEHOLDER] Sample Project");
            placeholder.setShortDescription("[PLACEHOLDER] This is temporary seed data used to test the projects template.");
            placeholder.setProblem("[PLACEHOLDER] Describe the problem here.");
            placeholder.setSolution("[PLACEHOLDER] Describe the solution here.");
            placeholder.setTechnologies(List.of("Java", "Spring Boot"));
            placeholder.setGithubUrl("https://github.com/example/placeholder");
            placeholder.setDemoUrl(null);
            placeholder.setStatus(ProjectStatus.IN_PROGRESS);
            placeholder.setFeatured(false);

            projectRepository.save(placeholder);
            System.out.println("[DataSeeder] Inserted placeholder project — replace with real project data.");
        }
    }
}