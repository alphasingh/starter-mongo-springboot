package com.uwindsor.mongo.repository;

import com.uwindsor.mongo.entity.ObjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectRepository extends MongoRepository<ObjectEntity, String> {
}