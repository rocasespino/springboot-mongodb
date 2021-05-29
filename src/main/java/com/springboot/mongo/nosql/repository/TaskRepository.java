package com.springboot.mongo.nosql.repository;

import com.springboot.mongo.nosql.model.Task;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String>{
    
}
