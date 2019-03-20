package com.example.mongodb.controller;

import com.example.mongodb.entity.Employee;
import com.example.mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class EmployeeController{

}

//@RestController
//public class EmployeeController {
//
//    private EmployeeService employeeService;
//
//    @Autowired
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//
//        List<Employee> employees = IntStream
//                .range(1, 10000)
//                .mapToObj(index -> new Employee(Long.valueOf(index), "Always the same name"))
//                .collect(toList());
//
//        employeeService.saveAll(Flux.fromIterable(employees)).subscribe();
//
//        System.out.println("Hey i am calling for all the employees now!");
//        employeeService.findAll().subscribe(employee -> System.out.println(employee.getId()));
//        System.out.println("Hey I dont have to wait");
//    }
//
//    @GetMapping("/employees/{id}")
//    private Mono<Employee> getEmployeeById(@PathVariable Long id) {
//        Mono<Employee> employeeMono = employeeService.findById(id);
//        employeeMono.subscribe(System.out::println);
//        return employeeMono;
//    }
//
//    @GetMapping("/employees")
//    public Flux<Employee> getAllEmployees() {
//        Flux<Employee> employeeFlux = employeeService.findAll();
//        employeeFlux.subscribe(f -> System.out.println("id = " + f.getId()));
//        return employeeFlux;
//    }
//
//    @PostMapping("/employees")
//    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
//        return employeeService.save(employee);
//    }
//}
