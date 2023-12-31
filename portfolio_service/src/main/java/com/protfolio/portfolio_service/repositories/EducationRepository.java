package com.protfolio.portfolio_service.repositories;

import com.protfolio.portfolio_service.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}