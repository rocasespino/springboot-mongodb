package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Task;
import com.springboot.mongo.nosql.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

       @Override
    public Optional<Task> readTask(String id) {
        return taskRepository.findById(id);
    }

      @Override
    public void deleteTask(String id) {
        taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Task task) {
        taskRepository.findById(task.getId()).orElseThrow(() -> new RuntimeException("Task not found"));
        return taskRepository.save(task);
    }


}
