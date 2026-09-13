package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.exception.DataLoadException;
import com.cloudstudio.portfolio.model.RoleResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final JsonMapper jsonMapper;

    public RoleServiceImpl(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<String> getAllRoles() {
        try {
            RoleResponse response = jsonMapper.readValue(
                    new ClassPathResource("data/roles.json").getInputStream(),
                    RoleResponse.class
            );
            return response.getRoles();
        } catch (IOException e) {
            throw new DataLoadException("Failed to load roles.json", e);
        }
    }
}