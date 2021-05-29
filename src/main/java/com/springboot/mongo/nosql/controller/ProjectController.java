package com.springboot.mongo.nosql.controller;

import com.springboot.mongo.nosql.model.Project;
import com.springboot.mongo.nosql.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(ProjectController.API_URL)
public class ProjectController {

    public static final String API_URL = "/project";

    private final ProjectService projectService;


    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Project> findProject(@RequestParam String projectId) {
        Optional<Project> project = projectService.readProject(projectId);
        if (!project.isPresent()){
            ResponseEntity.status(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.OK).body(project.get());
    }

    @PostMapping("/create-project")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        Project saved = projectService.saveProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

}
