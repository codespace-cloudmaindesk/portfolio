package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.content.JsonContentLoader;
import com.cloudstudio.portfolio.model.Skill;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final JsonContentLoader contentLoader;

    public SkillServiceImpl(JsonContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public List<Skill> getAllSkills() {
        return contentLoader.load("skills.json", new TypeReference<List<Skill>>() {});
    }

    @Override
    public List<String> getAllTools() {
        return getAllSkills().stream()
                .filter(skill -> skill.getTools() != null)
                .flatMap(skill -> skill.getTools().stream())
                .distinct()
                .toList();
    }
}