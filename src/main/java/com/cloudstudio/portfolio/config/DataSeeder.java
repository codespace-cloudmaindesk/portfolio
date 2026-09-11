package com.cloudstudio.portfolio.config;

import com.cloudstudio.portfolio.model.Metric;
import com.cloudstudio.portfolio.service.MetricService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedMetrics(MetricService metricService){
        return args -> {
            for (Metric metric : metricService.getAllMetrics()){
                System.out.println(metric.getTarget() + " | " + metric.getSuffix() + " | " + metric.getLabel());
            }
        };
    }
}
