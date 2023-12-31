package com.protfolio.portfolio_service.repositories;

import com.protfolio.portfolio_service.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}