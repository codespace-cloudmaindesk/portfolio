package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.entity.ContactMessage;
import com.cloudstudio.portfolio.service.ContactMessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedContactMessages(ContactMessageService contactMessageService) {
        return args -> {

            ContactMessage message = new ContactMessage();
            message.setName("Test User");
            message.setEmail("test@example.com");
            message.setMessage("This is a test message.");

            contactMessageService.saveMessage(message);

            for (ContactMessage m : contactMessageService.getAllContactMessages()) {
                System.out.println(m.getId() + " | " + m.getName() + " | " + m.getEmail() + " | " + m.getMessage() + " | " + m.getCreatedAt());
            }
        };
    }
}