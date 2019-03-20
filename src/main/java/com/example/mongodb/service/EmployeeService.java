package com.example.mongodb.service;

import com.example.mongodb.entity.Employee;
import com.example.mongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Flux<Employee> findAll(){
       return employeeRepository.findAll();
    }

    public Flux<Employee> saveAll(Flux<Employee> employeeFlux){
        return  employeeRepository.saveAll(employeeFlux);
    }

    public Mono<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Mono<Employee> save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Mono<Void> deleteAll(){
        return employeeRepository.deleteAll();
    }
}
