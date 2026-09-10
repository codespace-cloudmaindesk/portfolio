package com.cloudstudio.portfolio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Education {
    private String qualification;
    private String institution;
    private String period;
    private int level;
    private String status;
}