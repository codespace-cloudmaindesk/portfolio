package com.cloudstudio.portfolio.content;

import com.cloudstudio.portfolio.exception.DataLoadException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.io.InputStream;

@Component
public class JsonContentLoader {

    private static final String DATA_DIR = "data/";

    private final JsonMapper jsonMapper;

    public JsonContentLoader(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    public <T> T load(String fileName, Class<T> type) {
        return parse(fileName, jsonMapper.constructType(type));
    }

    public <T> T load(String fileName, TypeReference<T> type) {
        return parse(fileName, jsonMapper.constructType(type));
    }

    private <T> T parse(String fileName, JavaType type) {
        try (InputStream in = new ClassPathResource(DATA_DIR + fileName).getInputStream()) {
            return jsonMapper.readValue(in, type);
        } catch (IOException | JacksonException e) {
            throw new DataLoadException("Failed to load " + fileName, e);
        }
    }
}