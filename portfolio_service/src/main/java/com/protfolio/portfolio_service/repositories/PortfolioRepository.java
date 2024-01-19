package com.protfolio.portfolio_service.repositories;

import com.protfolio.portfolio_service.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    @Query("SELECT p FROM Portfolio p WHERE p.userid=:id")
    Portfolio findbyuserid(@Param("id") int id);
}