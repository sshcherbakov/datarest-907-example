package com.example;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.entity.MyEntity;
import com.example.repository.MyEntityRepository;

@SpringBootApplication
@EnableMongoRepositories	// <-- This explicit one is causing the DATAREST-907 issue
public class Datarest907ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Datarest907ExampleApplication.class, args);
	}
	
	@Autowired MyEntityRepository repository;

	@PostConstruct
	public void init() {

		MyEntity entity = new MyEntity();
		entity.setMyJodaTime(new DateTime());

		repository.save(entity);
	}
	
}
