package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.model.Certification;
import com.cloudstudio.portfolio.service.CertificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {
    @Bean
    public CommandLineRunner seedCertifications(CertificationService certificationService) {
        return args -> {
            for (Certification cert : certificationService.getAllCertification()) {
                System.out.println(cert.getName() + " | " + cert.getIssuer() + " | " + cert.getIssueDate() + " - " + cert.getExpirationDate());
            }
        };
    }
}
