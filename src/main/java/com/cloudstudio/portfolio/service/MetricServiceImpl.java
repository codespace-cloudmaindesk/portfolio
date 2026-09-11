package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.model.Metric;
import com.cloudstudio.portfolio.model.MetricResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.List;

@Service
public class MetricServiceImpl implements MetricService {

    @Override
    public List<Metric> getAllMetrics() {
        try {
            JsonMapper mapper = new JsonMapper();
            MetricResponse response = mapper.readValue(
                    new ClassPathResource("data/metrics.json").getInputStream(),
                    MetricResponse.class
            );
            return response.getMetrics();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load metrics.json", e);
        }
    }
}