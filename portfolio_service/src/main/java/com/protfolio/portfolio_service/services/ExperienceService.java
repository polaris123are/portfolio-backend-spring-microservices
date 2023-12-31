package com.protfolio.portfolio_service.services;

import com.protfolio.portfolio_service.entities.Experience;
import com.protfolio.portfolio_service.repositories.ExperienceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Transactional()
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Transactional()
    public Optional<Experience> findById(Long id) {
        return experienceRepository.findById(id);
    }

    @Transactional
    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience update(Long id, Experience updatedExperience) {
        return experienceRepository.findById(id)
                .map(experience -> {
                    experience.setDate(updatedExperience.getDate());
                    experience.setPosition(updatedExperience.getPosition());
                    experience.setLocation(updatedExperience.getLocation());
                    experience.setOrganization(updatedExperience.getOrganization());
                    // Add other fields as necessary
                    return experienceRepository.save(experience);
                }).orElseThrow(() -> new RuntimeException("Experience not found with id " + id));
    }


    @Transactional
    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }
}
