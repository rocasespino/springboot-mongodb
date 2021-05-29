package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Project;
import com.springboot.mongo.nosql.model.Task;
import com.springboot.mongo.nosql.repository.ProjectRepository;
import com.springboot.mongo.nosql.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final TaskRepository taskRepository;

    
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, 
                                TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
    
}
