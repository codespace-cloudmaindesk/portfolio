package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.content.JsonContentLoader;
import com.cloudstudio.portfolio.exception.DataLoadException;
import com.cloudstudio.portfolio.model.Education;
import com.cloudstudio.portfolio.model.EducationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl  implements EducationService{

    private final JsonContentLoader contentLoader;

    public EducationServiceImpl(JsonContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public List<Education> getAllEducation() {
        return contentLoader.load("education.json", EducationResponse.class).getEducation();
    }

    @Override
    public Education getEducationByQualification(String qualification) {
        return getAllEducation().stream()
            .filter(education -> qualification.equals(education.getQualification()))
            .findFirst()
            .orElseThrow(() -> new DataLoadException("Education qualification not found: " + qualification)
        );
    }
}