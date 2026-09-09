package com.cloudstudio.portfolio.repository;

import com.cloudstudio.portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
