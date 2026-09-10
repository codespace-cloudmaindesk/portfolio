package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.model.Skill;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Override
    public List<Skill> getAllSkills() {
        try {
            JsonMapper mapper = new JsonMapper();
            return mapper.readValue(
                    new ClassPathResource("data/skills.json").getInputStream(),
                    new TypeReference<List<Skill>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to load skills.json", e);
        }
    }
}