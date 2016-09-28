package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entity.MyEntity;

@RepositoryRestResource(path="myentities", collectionResourceRel="myEntities", itemResourceRel="myEntity")
public interface MyEntityRepository extends MongoRepository<MyEntity, String> {

}
