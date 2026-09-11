package com.cloudstudio.portfolio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProfessionalDevelopmentResponse {
    private List<ProfessionalDevelopment> professionalDevelopment;
}