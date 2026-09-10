package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.model.AboutContent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;

@Service
public class AboutServiceImpl implements AboutService {

    @Override
    public AboutContent getAboutContent() {
        try {
            JsonMapper mapper = new JsonMapper();
            return mapper.readValue(
                    new ClassPathResource("data/about.json").getInputStream(),
                    AboutContent.class
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to load about.json", e);
        }
    }
}