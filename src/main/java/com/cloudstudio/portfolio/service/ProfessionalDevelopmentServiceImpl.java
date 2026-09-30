package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.content.JsonContentLoader;
import com.cloudstudio.portfolio.model.ProfessionalDevelopment;
import com.cloudstudio.portfolio.model.ProfessionalDevelopmentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalDevelopmentServiceImpl implements ProfessionalDevelopmentService{

    private final JsonContentLoader contentLoader;

    public ProfessionalDevelopmentServiceImpl(JsonContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public List<ProfessionalDevelopment> getAllProfessionalDevelopment() {
        return contentLoader.load("professionalDevelopment.json", ProfessionalDevelopmentResponse.class).getProfessionalDevelopment();
    }
}