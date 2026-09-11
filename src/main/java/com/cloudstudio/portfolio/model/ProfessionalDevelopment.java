package com.cloudstudio.portfolio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProfessionalDevelopment {
    private String program;
    private String provider;
    private String period;
    private String status;
    private List<String> value;
    private List<String> impact;
}