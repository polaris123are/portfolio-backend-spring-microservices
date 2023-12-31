package com.protfolio.portfolio_service.services;

import com.protfolio.portfolio_service.entities.Project;
import com.protfolio.portfolio_service.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional()
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional()
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Transactional
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Transactional
    public Project update(Long id, Project updatedProject) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setTitle(updatedProject.getTitle());
                    project.setDescription(updatedProject.getDescription());
                    project.setGithubLink(updatedProject.getGithubLink());
                    project.setTools(updatedProject.getTools());
                    return projectRepository.save(project);
                }).orElseThrow(() -> new RuntimeException("Project not found with id " + id));
    }


    @Transactional
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}