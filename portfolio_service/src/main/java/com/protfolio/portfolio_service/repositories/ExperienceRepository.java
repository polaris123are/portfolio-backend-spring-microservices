package com.protfolio.portfolio_service.repositories;

import com.protfolio.portfolio_service.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}