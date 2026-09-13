package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.exception.DataLoadException;
import com.cloudstudio.portfolio.model.Certification;
import com.cloudstudio.portfolio.model.CertificationResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class CertificationServiceImpl implements CertificationService{

    private final JsonMapper jsonMapper;

    public CertificationServiceImpl(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<Certification> getAllCertification() {
        try {
            CertificationResponse response = jsonMapper.readValue(
                    new ClassPathResource("data/certifications.json").getInputStream(),
                    CertificationResponse.class
            );
            return response.getCertifications();
        } catch (IOException e) {
            throw new DataLoadException("Failed to load certifications.json", e);
        }
    }
}
