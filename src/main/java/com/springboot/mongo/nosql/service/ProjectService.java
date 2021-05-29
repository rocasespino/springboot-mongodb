package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Project;
import com.springboot.mongo.nosql.model.Task;

public interface ProjectService {
    public Project saveProject(Project project);

    public Task saveTask(Task task);
}
