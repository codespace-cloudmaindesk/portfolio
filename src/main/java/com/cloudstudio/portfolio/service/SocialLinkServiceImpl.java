package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.model.SocialLink;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class SocialLinkServiceImpl implements SocialLinkService {

    @Override
    public List<SocialLink> getAllSocialLinks() {
        try {
            JsonMapper mapper = new JsonMapper();
            return mapper.readValue(
                    new ClassPathResource("data/socialLinks.json").getInputStream(),
                    new TypeReference<List<SocialLink>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to load socialLinks.json", e);
        }
    }
}