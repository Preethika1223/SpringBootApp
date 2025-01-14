package com.example.employeeapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.employeeapp.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmployeeId(String employeeId);
}