package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.content.JsonContentLoader;
import com.cloudstudio.portfolio.model.SocialLink;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;

@Service
public class SocialLinkServiceImpl implements SocialLinkService {

    private final JsonContentLoader contentLoader;

    public SocialLinkServiceImpl(JsonContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public List<SocialLink> getAllSocialLinks() {
        return contentLoader.load("socialLinks.json", new TypeReference<List<SocialLink>>() {});
    }
}