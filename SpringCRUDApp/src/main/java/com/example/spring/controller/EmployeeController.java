package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.model.Employee;
import com.example.spring.service.EmployeeService;



@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empServices;
	
	
	@RequestMapping("/")
	public  ModelAndView homePage() 
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("listEmployees",empServices.getAllEmployees());
		mv.setViewName("index");
		
		return mv;
	}
	
	
	
	@RequestMapping("/showNewEmployeeForm")
	public  ModelAndView addEmployeePage() 
	{
		ModelAndView mv = new ModelAndView();
		Employee employee = new Employee();
		mv.addObject("employee",employee);
		mv.setViewName("new_employee");
		
		return mv;
	}
	
	
	@PostMapping("/saveEmployee")
	public  ModelAndView saveEmployeeButton(@ModelAttribute("employee") Employee employee) 
	{
		ModelAndView mv = new ModelAndView();
		//Save the Employee to the DB
		empServices.saveEmployee(employee);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping("/showFormForUpdate/{eid}")
	public  ModelAndView upddateEmployeeButton(@PathVariable(value="eid")long eid) 
	{
		ModelAndView mv = new ModelAndView();
		//get employee from the service
		Employee employeeById = empServices.getEmployeeById(eid);
		//set employee as model attribute to pre-populate the form
		mv.addObject("employee", employeeById);
		mv.setViewName("update_employee");
		return mv;
	}
	@GetMapping("/deleteEmployee/{eid}")
	public  ModelAndView deleteEmployeeButton(@PathVariable(value="eid")long eid) 
	{
		ModelAndView mv = new ModelAndView();
		//call delete employee method
		empServices.deleteEmployeeById(eid);
		
		mv.setViewName("redirect:/");
		return mv;
	}
	
}
