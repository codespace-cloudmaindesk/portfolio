package com.cloudstudio.portfolio.controller;

import com.cloudstudio.portfolio.service.MetricService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MetricController {

    private final MetricService metricService;

    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @GetMapping("/metrics")
    public String viewMetric(Model model) {
        model.addAttribute("metrics", metricService.getAllMetrics());
        return "metrics";
    }
}