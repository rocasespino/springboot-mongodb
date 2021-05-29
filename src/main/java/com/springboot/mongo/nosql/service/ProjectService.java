package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Project;
import com.springboot.mongo.nosql.model.Task;

import java.util.Optional;

public interface ProjectService {
    Project saveProject(Project project);

    Task saveTask(Task task);

    Optional<Project> readProject(String id);

    Optional<Task> readTask(String id);

    void deleteProject(String id);

    void deleteTask(String id);


}
