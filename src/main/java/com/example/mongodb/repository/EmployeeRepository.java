package com.example.mongodb.repository;

import com.example.mongodb.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Long> {

}
