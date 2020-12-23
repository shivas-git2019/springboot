package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.spring.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
