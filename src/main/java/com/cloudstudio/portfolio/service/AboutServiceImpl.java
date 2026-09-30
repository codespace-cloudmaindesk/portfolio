package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.content.JsonContentLoader;
import com.cloudstudio.portfolio.model.AboutContent;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements AboutService {

    private final JsonContentLoader contentLoader;

    public AboutServiceImpl(JsonContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public AboutContent getAboutContent() {
        return contentLoader.load("about.json",AboutContent.class);
    }
}