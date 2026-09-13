package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.exception.DataLoadException;
import com.cloudstudio.portfolio.model.SocialLink;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class SocialLinkServiceImpl implements SocialLinkService {

    private final JsonMapper jsonMapper;

    public SocialLinkServiceImpl(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<SocialLink> getAllSocialLinks() {
        try {
            return jsonMapper.readValue(
                    new ClassPathResource("data/socialLinks.json").getInputStream(),
                    new TypeReference<List<SocialLink>>() {}
            );
        } catch (IOException e) {
            throw new DataLoadException("Failed to load socialLinks.json", e);
        }
    }
}