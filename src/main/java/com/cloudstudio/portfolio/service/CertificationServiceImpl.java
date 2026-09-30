package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.content.JsonContentLoader;
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

    private final JsonContentLoader contentLoader;

    public CertificationServiceImpl(JsonContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public List<Certification> getAllCertification() {
        return contentLoader.load("certifications.json", CertificationResponse.class)
                .getCertifications();
    }
}
