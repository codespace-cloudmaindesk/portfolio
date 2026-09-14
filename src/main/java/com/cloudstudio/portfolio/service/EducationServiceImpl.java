package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.exception.DataLoadException;
import com.cloudstudio.portfolio.model.Education;
import com.cloudstudio.portfolio.model.EducationResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class EducationServiceImpl  implements EducationService{

    private final JsonMapper jsonMapper;

    public EducationServiceImpl(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<Education> getAllEducation() {
        try {
            EducationResponse response = jsonMapper.readValue(
                    new ClassPathResource("data/education.json").getInputStream(),
                    EducationResponse.class
            );
            return response.getEducation();
        } catch (IOException e) {
            throw new DataLoadException("Failed to load education.json", e);
        }
    }
}