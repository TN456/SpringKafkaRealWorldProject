package com.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.model.WikimediaData;

public interface WikimediaDataRepository extends MongoRepository<WikimediaData, String>{

}
