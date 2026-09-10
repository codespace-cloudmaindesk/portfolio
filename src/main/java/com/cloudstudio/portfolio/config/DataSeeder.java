package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.model.Skill;
import com.cloudstudio.portfolio.service.SkillService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedSkills(SkillService skillService) {
        return args -> {
            for (Skill skill : skillService.getAllSkills()) {
                System.out.println(skill.getName() + " - " + skill.getLevel());
            }
        };
    }
}
