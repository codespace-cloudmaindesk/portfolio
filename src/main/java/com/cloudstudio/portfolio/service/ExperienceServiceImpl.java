package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.content.JsonContentLoader;
import com.cloudstudio.portfolio.model.Experience;
import com.cloudstudio.portfolio.model.ExperienceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService{

    private final JsonContentLoader contentLoader;

    public ExperienceServiceImpl(JsonContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public List<Experience> getAllExperience() {
        return contentLoader.load("experience.json", ExperienceResponse.class).getExperience();
    }
}