package com.MongoDBCount.demo.repository;

import com.MongoDBCount.demo.model.HttpRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface HttpRequestRepository extends MongoRepository<HttpRequest,String> {
}
