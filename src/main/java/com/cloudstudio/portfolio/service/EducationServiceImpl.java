package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.model.Education;
import com.cloudstudio.portfolio.model.EducationResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class EducationServiceImpl  implements EducationService{

    @Override
    public List<Education> getAllEducation() {
        try {
            JsonMapper mapper = new JsonMapper();
            EducationResponse response = mapper.readValue(
                    new ClassPathResource("data/education.json").getInputStream(),
                    EducationResponse.class
            );
            return response.getEducation();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load education.json", e);
        }
    }
}
