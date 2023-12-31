package com.protfolio.portfolio_service.repositories;

import com.protfolio.portfolio_service.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}