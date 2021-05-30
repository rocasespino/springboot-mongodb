package com.springboot.mongo.nosql.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Task {

    @Id
    private String _id;

    private String projectId;

    private String name;

    @Field("desc")
    private String description;

    private String ownerName;

    private Long cost;

    @Version
    private Long version;
    
}
