package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.model.Employee;
import com.example.spring.repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
private EmployeeRepo employeeRepo;
	@Override
	public List<Employee> getAllEmployees() {
		
		return (List<Employee>) employeeRepo.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepo.save(employee);
		
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> findById = employeeRepo.findById(id);
		Employee employee=null;
		if(findById.isPresent()) {
			 employee = findById.get();
		}else {
			throw new RuntimeException("Employee not Found");
		}
		return employee;
	}
	
	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepo.deleteById(id);
		
	}

}
