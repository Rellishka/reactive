package com.example.mongodb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@Document(collection = "employee")
public class Employee {
    @Id
    private Long id;

    @Field(value = "fullName")
    private String fullName;

    public Employee(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}
