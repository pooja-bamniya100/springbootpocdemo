package com.neosoft.service;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.neosoft.dao.EmployeeRepository;
import com.neosoft.exception.ResourceNotFoundException;
import com.neosoft.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);

	}
    //hard delete
	public String deleteEmployee(String email)
	{
		employeeRepository.deleteById(email);
		return "Employee"+email+" sucsessfully deleted"	;
	}
	
	//edit employee
	public Employee updateEmployee(Employee employee) throws ResourceNotFoundException
	{
		Employee existingEmployee=null;
		String email=employee.getEmail();
			
			 existingEmployee=employeeRepository.findById(email).orElse(null);
			 if(existingEmployee ==null)
					throw new ResourceNotFoundException("Employee not found having id"+email);
				else {

		
		
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setEmployeeFirstName(employee.getEmployeeFirstName());
		existingEmployee.setEmployeeLastName(employee.getEmployeeLastName());
		existingEmployee.setEmployeeAddress(employee.getEmployeeAddress());
		existingEmployee.setFathersName(employee.getFathersName());
		existingEmployee.setContact(employee.getContact());
		existingEmployee.setDateOfJoining(employee.getDateOfJoining());
		existingEmployee.setDob(employee.getDob());
		existingEmployee.setPincode(employee.getPincode());
		existingEmployee.setSalary(employee.getSalary());
		existingEmployee.setStatus(employee.getStatus());
		employeeRepository.save(existingEmployee);

		return employeeRepository.save(existingEmployee);
				}
	}
	
	//soft delete
	public Employee deactivate(String email) throws ResourceNotFoundException
	{
		Employee existingEmployee=employeeRepository.findById(email).orElse(null);
		if(existingEmployee ==null)
			throw new ResourceNotFoundException("Employee not found having "+email);
		else {

		existingEmployee.setStatus(0);
		employeeRepository.save(existingEmployee);

		return employeeRepository.save(existingEmployee);
		}
	}
	//sorting based on dob or date of joining
	public List<Employee> getSortedEmployees(String sortBy) 
	{
		List<Employee> list=employeeRepository.findAll(Sort.by(sortBy));
		for(Employee e:list)
		System.out.println("dob"+e.getDob());
	 return list;
			
		
		
	}
       //searching
	public List<Employee> getemployee(String searchBy) throws ResourceNotFoundException 
	{ 
		List<Employee> list=list=employeeRepository.findByFirstNameOrLastNameOrPincode(searchBy);;
		if(list.isEmpty())
			throw new ResourceNotFoundException("Employee not found having "+searchBy);
		else

		return list;
		
	}



	/*
	 * public List<Employee> getEmployeeByEmployeeFirstName(String
	 * employeeFirstName) { return
	 * employeeRepository.findByEmployeeFirstName(employeeFirstName); }
	 * 
	 * public List<Employee> getEmployeeByEmployeeLastName(String employeeLastName)
	 * { return employeeRepository.findByEmployeeLastName(employeeLastName); }
	 * 
	 * public List<Employee> getEmployeeByPincode(int pincode) { return
	 * employeeRepository.findByPincode(pincode); }
	 */
}
