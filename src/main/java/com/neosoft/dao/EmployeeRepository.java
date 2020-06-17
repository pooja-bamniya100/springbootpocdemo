package com.neosoft.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.neosoft.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	/*
	 * List<Employee> findByEmployeeFirstName(String employeeFirstName);
	 * 
	 * List<Employee> findByEmployeeLastName(String employeeLastName);
	 * 
	 * List<Employee> findByPincode(int pincode);
	 */
	//List<Employee> findAllEmployees();
	List<Employee> findByFirstNameOrLastNameOrPincode(String searchBy);

}
