package com.cloudstudio.portfolio.entity;

import lombok.Getter;

public enum ProjectStatus {
    PLANNED("Planned"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    @Getter
    private final String displayName;

    ProjectStatus(String displayName) {
        this.displayName = displayName;
    }
}
