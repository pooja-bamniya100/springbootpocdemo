package com.neosoft;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.neosoft.dao.EmployeeRepository;
import com.neosoft.model.Employee;
import com.neosoft.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootPocApplicationTests {

	@Autowired
	EmployeeService employeeService;
	@MockBean
	EmployeeRepository employeeRepository;
	
	  @Test
	public void getSortedEmployeesTest()
	{
		List<Employee> list = new ArrayList<Employee>();
		Date dateOfJoining1=new Date(2020-3-9);
		Date dob1=new Date(1997-05-01);
        Employee emp1= new Employee("p@gmail.com","pooja","bamniya","dasharath",
        		6611556200l, "indore",dob1, dateOfJoining1,30000, "12345678",1, "454443");
    			
        Date dateOfJoining2=new Date(2019-4-9);
		Date dob2=new Date(1998-8-1);
        Employee emp2 = new Employee("a@gmail.com","arti","gupta","kamal",
        		6615676200l, "dhar",dob2, dateOfJoining2,46000, "66666",1, "454440");
    			
        Date dateOfJoining3=new Date(2019-3-7);
		Date dob3=new Date(1995-5-3);
        Employee emp3= new Employee("s@gmail.com","aunil","gupta","sachin",
        		6815676200l, "mumbai",dob3, dateOfJoining3,47000, "11111",1, "454443");
    	
    			 
       
         
        list.add(emp1);
        list.add(emp3);
        list.add(emp1);
		when(employeeRepository.findAll(Sort.by("dob"))).thenReturn(list);
		assertEquals(3,employeeService.getSortedEmployees("dob").size());
		 verify(employeeRepository, times(1)).findAll(Sort.by("dob"));
	}
}
