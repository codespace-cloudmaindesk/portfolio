package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.model.ProfessionalDevelopment;
import com.cloudstudio.portfolio.model.ProfessionalDevelopmentResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class ProfessionalDevelopmentServiceImpl implements ProfessionalDevelopmentService{

    @Override
    public List<ProfessionalDevelopment> getAllProfessionalDevelopment() {
        try {
            JsonMapper mapper = new JsonMapper();
            ProfessionalDevelopmentResponse response = mapper.readValue(
                    new ClassPathResource("data/professionalDevelopment.json").getInputStream(),
                    ProfessionalDevelopmentResponse.class
            );
            return response.getProfessionalDevelopment();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load professionalDevelopment.json", e);
        }
    }
}
