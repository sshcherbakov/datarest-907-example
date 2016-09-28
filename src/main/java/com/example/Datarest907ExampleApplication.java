package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Datarest907ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Datarest907ExampleApplication.class, args);
	}
}
