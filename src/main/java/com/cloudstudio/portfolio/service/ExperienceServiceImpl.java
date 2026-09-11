package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.model.Experience;
import com.cloudstudio.portfolio.model.ExperienceResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService{

    @Override
    public List<Experience> getAllExperience() {
        try {
            JsonMapper mapper = new JsonMapper();
            ExperienceResponse response = mapper.readValue(
                    new ClassPathResource("data/experience.json").getInputStream(),
                    ExperienceResponse.class
            );
            return response.getExperience();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load experience.json", e);
        }
    }
}
