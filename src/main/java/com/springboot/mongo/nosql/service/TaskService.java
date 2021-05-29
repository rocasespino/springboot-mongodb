package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Task;

import java.util.Optional;

public interface TaskService {

    Task saveTask(Task task);

    Optional<Task> readTask(String id);

    void deleteTask(String id);

    Task updateTask(Task task);


}
