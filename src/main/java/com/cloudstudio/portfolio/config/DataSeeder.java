package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.model.ProfessionalDevelopment;
import com.cloudstudio.portfolio.service.ProfessionalDevelopmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedProfessionalDevelopment(ProfessionalDevelopmentService professionalDevelopmentService) {
        return args -> {
            for (ProfessionalDevelopment pd : professionalDevelopmentService.getAllProfessionalDevelopment()) {
                System.out.println(pd.getProgram() + " - " + pd.getProvider());
                System.out.println("  Value: " + pd.getValue());
                System.out.println("  Impact: " + pd.getImpact());
            }
        };
    }


}
