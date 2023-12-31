package com.protfolio.portfolio_service.repositories;

import com.protfolio.portfolio_service.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}