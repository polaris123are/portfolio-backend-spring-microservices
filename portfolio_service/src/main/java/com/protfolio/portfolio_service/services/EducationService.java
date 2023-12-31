package com.protfolio.portfolio_service.services;

import com.protfolio.portfolio_service.entities.Education;
import com.protfolio.portfolio_service.repositories.EducationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;

    @Transactional()
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Transactional()
    public Optional<Education> findById(Long id) {
        return educationRepository.findById(id);
    }

    @Transactional
    public Education save(Education education) {
        return educationRepository.save(education);
    }

    @Transactional
    public Education update(Long id, Education updatedEducation) {
        return educationRepository.findById(id)
                .map(education -> {
                    education.setSchool(updatedEducation.getSchool());
                    education.setDegree(updatedEducation.getDegree());
                    education.setFieldOfStudy(updatedEducation.getFieldOfStudy());
                    education.setStartDate(updatedEducation.getStartDate());
                    education.setEndDate(updatedEducation.getEndDate());
                    education.setDescription(updatedEducation.getDescription());
                    // Add other fields as necessary
                    return educationRepository.save(education);
                }).orElseThrow(() -> new RuntimeException("Education not found with id " + id));
    }


    @Transactional
    public void delete(Long id) {
        educationRepository.deleteById(id);
    }
}
