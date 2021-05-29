package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Project;

import java.util.Optional;

public interface ProjectService {
    Project saveProject(Project project);

    Optional<Project> readProject(String id);

    void deleteProject(String id);

    Project updateProject(Project project);

}
