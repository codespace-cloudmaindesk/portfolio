package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.exception.DataLoadException;
import com.cloudstudio.portfolio.model.Metric;
import com.cloudstudio.portfolio.model.MetricResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class MetricServiceImpl implements MetricService {

    private final JsonMapper jsonMapper;

    public MetricServiceImpl(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @Override
    public List<Metric> getAllMetrics() {
        try {
            MetricResponse response = jsonMapper.readValue(
                    new ClassPathResource("data/metrics.json").getInputStream(),
                    MetricResponse.class
            );
            return response.getMetrics();
        } catch (IOException e) {
            throw new DataLoadException("Failed to load metrics.json", e);
        }
    }
}