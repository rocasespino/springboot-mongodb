package com.springboot.mongo.nosql.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Data
public class Project {

    @Id
    private String id;

    private String name;

    private String code;

    @Field("desc")
    private String description;

    private String startDate;

    private String endDate;

    private Long estimatedCost;

    private List<String> countryList;

    @Version
    private Long version;
    
}
