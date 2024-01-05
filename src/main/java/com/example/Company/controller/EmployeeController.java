package com.example.Company.controller;

import java.util.List;

import com.example.Company.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Company.entity.Employee;
import com.example.Company.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest){
		return employeeService.createEmployee(employeeRequest);
	}
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}

	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable Long employeeId){
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PutMapping("/{employeeId}")
	public Employee updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee) {
		employee.setEmployeeId(employeeId);
		return employeeService.updateEmployee(employeeId,employee);
	}
	
	@DeleteMapping("/{employeeId}")
	public String deleteEmployee(@PathVariable Long employeeId){
		return employeeService.deleteEmployee(employeeId);
	}
}
