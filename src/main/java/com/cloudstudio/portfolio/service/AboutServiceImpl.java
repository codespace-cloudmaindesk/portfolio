package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.exception.DataLoadException;
import com.cloudstudio.portfolio.model.AboutContent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.zip.DataFormatException;

@Service
public class AboutServiceImpl implements AboutService {

    private final JsonMapper jsonMapper;

    public AboutServiceImpl(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public AboutContent getAboutContent() {
        try {
            return jsonMapper.readValue(
                    new ClassPathResource("data/about.json").getInputStream(),
                    AboutContent.class
            );
        } catch (IOException e) {
            throw new DataLoadException("Failed to load about.json", e);
        }
    }
}