package com.cloudstudio.portfolio.service;

import com.cloudstudio.portfolio.content.JsonContentLoader;
import com.cloudstudio.portfolio.model.Metric;
import com.cloudstudio.portfolio.model.MetricResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricServiceImpl implements MetricService {

    private final JsonContentLoader contentLoader;

    public MetricServiceImpl(JsonContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }

    @Override
    public List<Metric> getAllMetrics() {
       return contentLoader.load("metrics.json", MetricResponse.class).getMetrics();
    }
}