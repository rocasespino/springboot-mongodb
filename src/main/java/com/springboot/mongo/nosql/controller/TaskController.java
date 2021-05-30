package com.springboot.mongo.nosql.controller;

import com.springboot.mongo.nosql.model.Task;
import com.springboot.mongo.nosql.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TaskController.API_URL)
public class TaskController {
    public static final String API_URL = "/tasks";

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create-task")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task saved = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
