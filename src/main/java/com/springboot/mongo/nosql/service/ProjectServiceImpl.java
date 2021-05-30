package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Project;
import com.springboot.mongo.nosql.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> readProject(String id) {
        return projectRepository.findById(id);
    }


    @Override
    public void deleteProject(String id) {
        projectRepository.findById(id).orElseThrow(()->new RuntimeException("Project not found"));
        projectRepository.deleteById(id);
    }


    @Override
    public Project updateProject(Project project) {
        projectRepository.findById(project.get_id()).orElseThrow(() -> new RuntimeException("Project not found"));
        return projectRepository.save(project);
    }

}
