package com.cloudstudio.portfolio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Experience {
    private String role;
    private String company;
    private String period;
    private String location;
    private String type;
    private String description;
    private List<String> responsibilities;
}