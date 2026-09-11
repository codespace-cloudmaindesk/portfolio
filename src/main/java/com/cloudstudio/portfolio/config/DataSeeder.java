package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.model.Experience;
import com.cloudstudio.portfolio.service.ExperienceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedExperience(ExperienceService experienceService) {
        return args -> {
            for (Experience experience : experienceService.getAllExperience()) {
                System.out.println(experience.getRole() + " at " + experience.getCompany() + " (" + experience.getPeriod() + ")");
                for (String responsibility : experience.getResponsibilities()) {
                    System.out.println("  - " + responsibility);
                }
            }
        };
    }
}
