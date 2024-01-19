package com.protfolio.portfolio_service.repositories;

import com.protfolio.portfolio_service.entities.Experience;
import com.protfolio.portfolio_service.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageReposetory extends JpaRepository<Image, Long> {

}
