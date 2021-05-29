package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Project;
import com.springboot.mongo.nosql.model.Task;
import com.springboot.mongo.nosql.repository.ProjectRepository;
import com.springboot.mongo.nosql.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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

    @Override
    public Optional<Project> readProject(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public Optional<Task> readTask(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public void deleteProject(String id) {
        projectRepository.findById(id).orElseThrow(()->new RuntimeException("Project not found"));
        projectRepository.deleteById(id);
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.deleteById(id);
    }

    @Override
    public Project updateProject(Project project) {
        projectRepository.findById(project.getId()).orElseThrow(() -> new RuntimeException("Project not found"));
        return projectRepository.save(project);
    }

    @Override
    public Task updateTask(Task task) {
        taskRepository.findById(task.getId()).orElseThrow(() -> new RuntimeException("Task not found"));
        return taskRepository.save(task);
    }


}
