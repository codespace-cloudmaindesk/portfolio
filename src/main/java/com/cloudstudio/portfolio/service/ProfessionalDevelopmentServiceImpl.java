package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.exception.DataLoadException;
import com.cloudstudio.portfolio.model.ProfessionalDevelopment;
import com.cloudstudio.portfolio.model.ProfessionalDevelopmentResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class ProfessionalDevelopmentServiceImpl implements ProfessionalDevelopmentService{

    private final JsonMapper jsonMapper;

    public ProfessionalDevelopmentServiceImpl(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<ProfessionalDevelopment> getAllProfessionalDevelopment() {
        try {
            ProfessionalDevelopmentResponse response = jsonMapper.readValue(
                    new ClassPathResource("data/professionalDevelopment.json").getInputStream(),
                    ProfessionalDevelopmentResponse.class
            );
            return response.getProfessionalDevelopment();
        } catch (IOException e) {
            throw new DataLoadException("Failed to load professionalDevelopment.json", e);
        }
    }
}