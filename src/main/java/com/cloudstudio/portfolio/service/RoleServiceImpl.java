package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.content.JsonContentLoader;
import com.cloudstudio.portfolio.model.RoleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final JsonContentLoader contentLoader;

    public RoleServiceImpl(JsonContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public List<String> getAllRoles() {
       return contentLoader.load("roles.json", RoleResponse.class).getRoles();
    }
}