package com.example.Company.service;

import java.util.List;
import java.util.Optional;

import com.example.Company.entity.Designation;
import com.example.Company.repository.DesignationRepository;
import com.example.Company.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Company.entity.Employee;
import com.example.Company.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DesignationRepository designationRepository;
	
	public Employee createEmployee(EmployeeRequest employeeRequest){

		Employee employee =new Employee();

		Optional<Designation> designation = designationRepository.findById(employeeRequest.getDesignationId());

		employee.setDesignationMap(designation.get());
		employee.setFirstName(employeeRequest.getFirstName());
		employee.setLastName(employeeRequest.getLastName());
		employee.setEmail(employeeRequest.getEmail());
		employee.setContactNumber(employeeRequest.getContactNumber());
		employee.setStatus(employeeRequest.getStatus());
		employee.setCreatedDate(employeeRequest.getCreatedDate());
		employee.setCreatedUser(employeeRequest.getCreatedUser());
		employee.setModifiedDate(employeeRequest.getModifiedDate());
		employee.setModifiedUser(employeeRequest.getModifiedUser());

		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(Long employeeId){
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		return optionalEmployee.get();
	}
	
	public Employee updateEmployee(Long employeeId,Employee employee){
		
	//	Employee existingEmployee =employeeRepository.findById(employee.getEmployeeId()).get();

		Employee existingEmployee =employeeRepository.findById(employeeId).get();
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setContactNumber(employee.getContactNumber());
		existingEmployee.setStatus(employee.getStatus());
		existingEmployee.setCreatedDate(employee.getCreatedDate());
		existingEmployee.setCreatedUser(employee.getCreatedUser());
		existingEmployee.setModifiedDate(employee.getModifiedDate());
		existingEmployee.setModifiedUser(employee.getModifiedUser());
		
		Employee updatedEmployee =employeeRepository.save(existingEmployee);
		
		return updatedEmployee;
		
	}
	
	public String deleteEmployee(Long employeeId){
		Optional<Employee> employee=employeeRepository.findById(employeeId);
		if(employee.isPresent()){
			employeeRepository.deleteById(employeeId);
			return "Successfully Deleted";
		}else{
			return "Not found";
		}
	}
}
