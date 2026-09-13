package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.exception.DataLoadException;
import com.cloudstudio.portfolio.model.Skill;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final JsonMapper jsonMapper;

    public SkillServiceImpl(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<Skill> getAllSkills() {
        try {
            return jsonMapper.readValue(
                    new ClassPathResource("data/skills.json").getInputStream(),
                    new TypeReference<List<Skill>>() {}
            );
        } catch (IOException e) {
            throw new DataLoadException("Failed to load skills.json", e);
        }
    }
}