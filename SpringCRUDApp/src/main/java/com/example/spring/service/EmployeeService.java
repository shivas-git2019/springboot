package com.example.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.model.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
	 Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
	
}
