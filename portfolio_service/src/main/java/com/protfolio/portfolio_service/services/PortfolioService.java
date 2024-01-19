package com.protfolio.portfolio_service.services;

import com.protfolio.portfolio_service.entities.Portfolio;
import com.protfolio.portfolio_service.repositories.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Transactional(readOnly = true)
    public List<Portfolio> findAll() {

        return portfolioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Portfolio> findById(Long id) {
        return portfolioRepository.findById(id);
    }

    @Transactional
    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Transactional
    public void delete(Long id) {
        portfolioRepository.deleteById(id);
    }

    @Transactional
    public Portfolio update(Long id, Portfolio updatedPortfolio) {
        return portfolioRepository.findById(id)
                .map(portfolio -> {
                    // Update fields of the portfolio
                    portfolio.setImagePath(updatedPortfolio.getImagePath());
                    portfolio.setAboutMe(updatedPortfolio.getAboutMe());
                    // ... other fields as necessary
                    return portfolioRepository.save(portfolio);
                }).orElseThrow(() -> new RuntimeException("Portfolio not found with id " + id));
    }


}
