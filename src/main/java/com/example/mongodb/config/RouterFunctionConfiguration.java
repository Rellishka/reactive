package com.example.mongodb.config;

import com.example.mongodb.entity.Employee;
import com.example.mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
//@EnableWebFlux
public class RouterFunctionConfiguration// implements WebFluxConfigurer
{
    private EmployeeService employeeService;

    @Autowired
    public RouterFunctionConfiguration(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route(GET("/employees"), this::getAllEmployees)
                .andRoute(GET("/employees/{id}"), this::getEmployeeById)
                .andRoute(POST("/employees"), this::createEmployee);
    }

    @Bean
    public RouterFunction<ServerResponse> getEmployeeByIdRoute() {
        return route(GET("/employees/{id}"), this::getEmployeeById);
    }


    public Mono<ServerResponse> getAllEmployees(ServerRequest request) {
        return ok()
                .body(employeeService.findAll(), Employee.class);
    }

    public Mono<ServerResponse> getEmployeeById(ServerRequest request) {
        long id = Long.parseLong(request.pathVariable("id"));
        return ok()
                .body(employeeService.findById(id), Employee.class);
    }

    public Mono<ServerResponse> createEmployee(ServerRequest request) {
        return request.body(toMono(Employee.class))
                .doOnNext(employeeService::save)
                .then(ok().build());
    }
}
