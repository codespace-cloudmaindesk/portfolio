package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.model.SocialLinks;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class SocialLinksServiceImpl implements SocialLinksService {

    @Override
    public List<SocialLinks> getAllSocialLinks() {
        try {
            JsonMapper mapper = new JsonMapper();
            return mapper.readValue(
                    new ClassPathResource("data/socialLinks.json").getInputStream(),
                    new TypeReference<List<SocialLinks>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to load socialLinks.json", e);
        }
    }
}