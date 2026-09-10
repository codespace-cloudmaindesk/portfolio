package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.service.AboutService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedAbout(AboutService aboutService) {
        return args -> {
            System.out.println(aboutService.getAboutContent().getTitle());
            System.out.println(aboutService.getAboutContent().getContent());
        };
    }
}
