package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project saveProject(Project project);

    Optional<Project> readProject(String id);

    void deleteProject(String id);

    Project updateProject(Project project);

    List<Project> findByName(String name);

    List<Project>  findByNameNot(String name);

    List<Project>  findByEstimatedCostGreaterThan(Long cost);

    List<Project>  findByEstimatedCostBetween(Long from, Long to);

    List<Project>  findByNameLike(String name);

    List<Project>  findByNameRegex(String name);

    List<Project>  findByNameWithTemplate(String name);

    List<Project>  findByEstimatedCostBetweenTemplate(Long from, Long to);

    void upsertCostWithCriteriaTemplate(String id, Long cost);

    void deleteProjectWithCriteriaTemplate(String id);

}
