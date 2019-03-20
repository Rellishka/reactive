package com.example.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
public class MongoFluxApplication{

	public static void main(String[] args) {
		SpringApplication.run(MongoFluxApplication.class, args);
	}
}

