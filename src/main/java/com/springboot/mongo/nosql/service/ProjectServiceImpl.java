package com.springboot.mongo.nosql.service;

import com.springboot.mongo.nosql.model.Project;
import com.springboot.mongo.nosql.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final MongoTemplate mongoTemplate;

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> readProject(String id) {
        return projectRepository.findById(id);
    }


    @Override
    public void deleteProject(String id) {
        projectRepository.findById(id).orElseThrow(()->new RuntimeException("Project not found"));
        projectRepository.deleteById(id);
    }


    @Override
    public Project updateProject(Project project) {
        projectRepository.findById(project.get_id()).orElseThrow(() -> new RuntimeException("Project not found"));
        return projectRepository.save(project);
    }

    @Override
    public List<Project> findByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public List<Project> findByNameNot(String name) {
        return projectRepository.findByNameNot(name);
    }

    @Override
    public List<Project> findByEstimatedCostGreaterThan(Long cost) {
        return projectRepository.findByEstimatedCostGreaterThan(cost);
    }

    @Override
    public List<Project> findByEstimatedCostBetween(Long from, Long to) {
        return projectRepository.findByEstimatedCostBetween(from,to);
    }

    @Override
    public List<Project> findByNameLike(String name) {
        return projectRepository.findByNameLike(name);
    }

    @Override
    public List<Project> findByNameRegex(String name) {
        String regex = "^" + name;
        return projectRepository.findByNameRegex(regex);
    }

    @Override
    public List<Project> findByNameWithTemplate(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Project.class);
    }

    @Override
    public List<Project> findByEstimatedCostBetweenTemplate(Long from, Long to) {
        Query query = new Query();
        query.addCriteria(Criteria.where("cost").gt(from).lt(to));
        return  mongoTemplate.find(query, Project.class);
    }

    @Override
    public void upsertCostWithCriteriaTemplate(String id, Long cost) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("cost", cost);
        mongoTemplate.upsert(query, update, Project.class);
    }

    @Override
    public void deleteProjectWithCriteriaTemplate(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Project.class);
    }
}
