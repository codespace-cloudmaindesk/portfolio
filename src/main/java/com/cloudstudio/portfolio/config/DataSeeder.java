package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.model.SocialLink;
import com.cloudstudio.portfolio.service.SocialLinkService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {
    @Bean
    public CommandLineRunner seedSocialLink(SocialLinkService socialLinkService){
        return args -> {
            for (SocialLink link : socialLinkService.getAllSocialLinks()){
                System.out.println(link.getLabel() + " | " + link.getIcon() + " | " + link.getUrl());
            };
        };
    }
}
