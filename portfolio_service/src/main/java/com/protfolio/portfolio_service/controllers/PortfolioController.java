package com.protfolio.portfolio_service.controllers;

import com.protfolio.portfolio_service.entities.Portfolio;
import com.protfolio.portfolio_service.repositories.PortfolioRepository;
import com.protfolio.portfolio_service.services.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PortfolioController {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioService portfolioService;

    @GetMapping
    public ResponseEntity<List<Portfolio>> getAllPortfolios() {
        return
                ResponseEntity.ok(portfolioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable Long id) {
        return portfolioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{id}")
        public Portfolio getportfoliobyuserid(@PathVariable int id) {
        return portfolioRepository.findbyuserid(id);
    }

    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        Portfolio a=new  Portfolio();
        a.setCertificates(portfolio.getCertificates());
        a.setAboutMe(portfolio.getAboutMe());
        a.setEmail(portfolio.getEmail());
        a.setEducation(portfolio.getEducation());
        a.setProjects(portfolio.getProjects());
        a.setPhoneNumber(portfolio.getPhoneNumber());
        a.setSpecialization(portfolio.getSpecialization());
        a.setLinkedIn(portfolio.getLinkedIn());
        a.setWorkExperience(portfolio.getWorkExperience());
        a.setTwitter(portfolio.getTwitter());
        a.setTechnologies(portfolio.getTechnologies());
        a.setImagePath(a.getImagePath());
        a.setUserid(portfolio.getUserid());
    return ResponseEntity.ok(portfolioService.save(a));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolio) {
        return ResponseEntity.ok(portfolioService.update(id, portfolio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id) {
        portfolioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
