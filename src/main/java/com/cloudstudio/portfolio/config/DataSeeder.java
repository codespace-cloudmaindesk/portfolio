package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.model.Education;
import com.cloudstudio.portfolio.service.EducationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {
    @Bean
    public CommandLineRunner seedEducation(EducationService educationService) {
        return args -> {
            for (Education education : educationService.getAllEducation()) {
                System.out.println(education.getQualification() + " - " + education.getInstitution() + " - NQF " + education.getLevel());
            }
        };
    }

}
