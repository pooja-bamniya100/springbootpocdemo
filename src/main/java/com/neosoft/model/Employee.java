package com.neosoft.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;



@Entity
@NamedQuery(name = "Employee.findByFirstNameOrLastNameOrPincode",
query = "select e from Employee e where e.employeeFirstName = ?1 or e.employeeLastName= ?1 or e.pincode= ?1")
public class Employee {
	@Id
	@Email(message="email should be in standard form")
	private String email;
	@NotNull(message = "name cannot null")
	@Size(min=2,message="name shoulld have minimum 2 character")
	private String employeeFirstName;
	@NotNull(message = "surname is mandatory")
	private String employeeLastName;
	private String FathersName;

	@NotNull(message = "contact no is mandatory")
	//@Size(max=10,min=10)
	private long contact;
	private String employeeAddress;

	//@Past
	@NotNull(message = "Dob is mandatory")
	private Date dob;
	@NotNull(message = "please enter joinng date")
	private Date dateOfJoining;
	@NotNull(message = "please enter your salary")
	private int salary;
	@NotNull(message="please enter password")
	@Size(min=8,max=16,message="password must have minimum 8 character  and maximum  16 character ")
	private String password;
	public String getPassword() {
		return password;
	}
	public int status;
	private String pincode;
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public String getFathersName() {
		return FathersName;
	}
	public void setFathersName(String fathersName) {
		FathersName = fathersName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(@Email(message = "email should be in standard form") String email,
			@NotNull(message = "name cannot null") @Size(min = 2, message = "name shoulld have minimum 2 character") String employeeFirstName,
			@NotNull(message = "surname is mandatory") String employeeLastName, String fathersName,
			@NotNull(message = "contact no is mandatory") long contact, String employeeAddress,
			@NotNull(message = "Dob is mandatory") Date string,
			@NotNull(message = "please enter joinng date") Date string2,
			@NotNull(message = "please enter your salary") int salary,
			@NotNull(message = "please enter password") @Size(min = 8, max = 16, message = "password must have minimum 8 character  and maximum  16 character ") String password,
			int status, String pincode) {
		super();
		this.email = email;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		FathersName = fathersName;
		this.contact = contact;
		this.employeeAddress = employeeAddress;
		this.dob = string;
		this.dateOfJoining = string2;
		this.salary = salary;
		this.password = password;
		this.status = status;
		this.pincode = pincode;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [email=" + email + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", FathersName=" + FathersName + ", contact=" + contact + ", employeeAddress="
				+ employeeAddress + ", dob=" + dob + ", dateOfJoining=" + dateOfJoining + ", salary=" + salary
				+ ", password=" + password + ", status=" + status + ", pincode=" + pincode + "]";
	}




}
