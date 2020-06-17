package com.neosoft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.dao.EmployeeRepository;
import com.neosoft.exception.ResourceNotFoundException;
import com.neosoft.model.Employee;

import com.neosoft.service.EmployeeService;


@RestController
public class EmployeeController {


	@Autowired
	EmployeeService employeeService;

	//api for registeration
	
	@PostMapping("/employee")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	//api for hard delete
	@DeleteMapping("/employee/{email}")
	public String deleteEmployee(@PathVariable String email) throws ResourceNotFoundException
	{
		String msg=null;
		try {
		msg= employeeService.deleteEmployee(email);
		}
		catch(Exception ex)
		{
			throw new ResourceNotFoundException("Employee not found having id "+email);
		}
		return msg;
		

	}
	
	//api for update
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) throws ResourceNotFoundException
	{

		
			return  employeeService.updateEmployee(employee);
		

	}
	//api for soft delete
	@PutMapping("/deactivate/{email}")
	public Employee deactivate(@RequestBody Employee employee) throws ResourceNotFoundException
	{

		return  employeeService.updateEmployee(employee);


	}
	
	//api for sorting based on dob or dateofjoining
	@GetMapping("/sortedEmployees/{sortBy}")
	public List<Employee> getSortedEmployees(@PathVariable String sortBy)
	{
		return employeeService.getSortedEmployees(sortBy);
	}

	//api for dynamic search
	
	 @GetMapping("/employees/{searchBy}")
	 public List<Employee> getemployee(@PathVariable
			 ("searchBy")String searchBy) throws ResourceNotFoundException 
	 { 
		 return employeeService.getemployee(searchBy); 
		 }
	 
	 
	 /*
		 * @GetMapping("/employeeByEmployeeFirstName/{employeeFirstName}") public
		 * List<Employee>
		 * getEmployeeByEmployeeFirstName(@PathVariable("employeeFirstName") String
		 * employeeFirstName) { return
		 * employeeService.getEmployeeByEmployeeFirstName(employeeFirstName); }
		 * 
		 * @GetMapping("/employeeByEmployeeLastName/{employeeLastName}") public
		 * List<Employee> getEmployeeByEmployeeLastName(@PathVariable
		 * ("employeeLastName")String employeeLastName) { return
		 * employeeService.getEmployeeByEmployeeLastName(employeeLastName); }
		 * 
		 * @GetMapping("/employeeByPincode/{pincode}") public List<Employee>
		 * getEmployeeByPincode(@PathVariable int pincode) { return
		 * employeeService.getEmployeeByPincode(pincode); }
		 */
		
}
