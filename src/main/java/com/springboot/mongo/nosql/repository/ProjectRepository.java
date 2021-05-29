package com.springboot.mongo.nosql.repository;

import com.springboot.mongo.nosql.model.Project;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
    
}
