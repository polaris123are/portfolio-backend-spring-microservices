package com.protfolio.portfolio_service.repositories;

import com.protfolio.portfolio_service.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}