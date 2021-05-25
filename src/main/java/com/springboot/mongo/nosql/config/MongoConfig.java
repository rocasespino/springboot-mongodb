package com.springboot.mongo.nosql.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.springboot.mongo.nosql.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.name}")
    private String replicaSetName;

    @Value("${spring.data.mongodb.authMechanism}")
    private String authMechanism;
    
    @Value("${spring.data.mongodb.username}")
    private String replicaSetUsername;
    
    @Value("${spring.data.mongodb.password}")
    private String replicaSetPassword;
    
    @Value("${spring.data.mongodb.primary}")
    private String replicaSetPrimary;

    @Value("${spring.data.mongodb.port}")
    private String replicaSetPort;
    
    @Value("${spring.data.mongodb.maxPoolSize}")
    private String replicaSetMaxPoolSize;
    
    @Value("${spring.data.mongodb.authentication-database}")
    private String replicaSetAuthDb;

    @Override
    public MongoClient mongoClient(){
        return MongoClients.create("mongodb://" + 
        replicaSetUsername + ":" + 
        replicaSetPassword + "@" + replicaSetPrimary + ":" + replicaSetPort + "/" +  database + 
        "?replicaSet=" + replicaSetName + 
        "&authSource=" + replicaSetAuthDb + 
        "&maxPoolSize="+ replicaSetMaxPoolSize + 
        "&ssl=false"); 
    }

    @Override
    protected  String getDatabaseName() {
        return database;
    }
    
}
