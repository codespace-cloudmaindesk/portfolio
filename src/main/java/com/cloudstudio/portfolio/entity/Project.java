package com.cloudstudio.portfolio.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "problem")
    private String problem;

    @Column(name = "solution")
    private String solution;

    @ElementCollection
    @CollectionTable(name = "project_technologies", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "technology")
    private List<String> technologies = new ArrayList<>();

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "demo_url")
    private String demoUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProjectStatus status;

    @Column(name = "featured")
    private boolean featured;

    @Setter(AccessLevel.NONE)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
