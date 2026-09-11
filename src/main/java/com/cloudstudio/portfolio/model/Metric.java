package com.cloudstudio.portfolio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Metric {
    private int target;
    private String suffix;
    private String label;
}
