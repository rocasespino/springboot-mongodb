package com.springboot.mongo.nosql.repository;

import com.springboot.mongo.nosql.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {

    List<Project>  findByName(String name);

    List<Project>  findByNameNot(String name);

    List<Project>  findByEstimatedCostGreaterThan(Long cost);

    List<Project>  findByEstimatedCostBetween(Long from, Long to);

    List<Project>  findByNameLike(String name);

    List<Project>  findByNameRegex(String name);

    @Query("{'name' : ?0}")
    List<Project>  findByNameQuery(String name);

    @Query("{'name' : { $ne : ?0}}")
    List<Project>  findByNameNotQuery(String name);

    @Query("{'name' : ?0, 'cost' : ?1}")
    List<Project>  findByNameAndCostQuery(String name, Long cost);

    @Query("{'cost' : { $gt : ?0, $lt : ?1}}")
    List<Project>  findByEstimatedCostBetweenQuery(Long from, Long to);

    //returns the list of projects that match the regex on name, but only populating the mentioned fields (name and cost)
    @Query(value= "{'name' : { $regex : ?0}}", fields = "{'name' : 1, 'cost' : 1}")
    List<Project>  findByNameRegexQuery(String regex);

}
