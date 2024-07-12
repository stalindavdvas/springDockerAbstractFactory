package com.cap.cursos.factory;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.cap.cursos.repository.mongo")
public class MongoConfig {
}