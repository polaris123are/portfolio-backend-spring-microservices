package com.protfolio.portfolio_service.services;

import com.protfolio.portfolio_service.entities.Technology;
import com.protfolio.portfolio_service.repositories.TechnologyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    @Transactional()
    public List<Technology> findAll() {
        return technologyRepository.findAll();
    }

    @Transactional()
    public Optional<Technology> findById(Long id) {
        return technologyRepository.findById(id);
    }

    @Transactional
    public Technology save(Technology technology) {
        return technologyRepository.save(technology);
    }

    public Technology update(Long id, Technology updatedTechnology) {
        return technologyRepository.findById(id)
                .map(technology -> {
                    technology.setName(updatedTechnology.getName());
                    technology.setImage(updatedTechnology.getImage());
                    // Add other fields as necessary
                    return technologyRepository.save(technology);
                }).orElseThrow(() -> new RuntimeException("Technology not found with id " + id));
    }


    @Transactional
    public void delete(Long id) {
        technologyRepository.deleteById(id);
    }
}
