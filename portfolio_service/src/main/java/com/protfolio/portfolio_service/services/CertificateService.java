package com.protfolio.portfolio_service.services;

import com.protfolio.portfolio_service.entities.Certificate;
import com.protfolio.portfolio_service.repositories.CertificateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository certificateRepository;

    @Transactional()
    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    @Transactional()
    public Optional<Certificate> findById(Long id) {
        return certificateRepository.findById(id);
    }

    @Transactional
    public Certificate save(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public Certificate update(Long id, Certificate updatedCertificate) {
        return certificateRepository.findById(id)
                .map(certificate -> {
                    certificate.setImagePath(updatedCertificate.getImagePath());
                    certificate.setName(updatedCertificate.getName());
                    certificate.setOrganizationIssuedBy(updatedCertificate.getOrganizationIssuedBy());
                    certificate.setSpecialization(updatedCertificate.getSpecialization());
                    // Add other fields as necessary
                    return certificateRepository.save(certificate);
                }).orElseThrow(() -> new RuntimeException("Certificate not found with id " + id));
    }

    @Transactional
    public void delete(Long id) {
        certificateRepository.deleteById(id);
    }
}

