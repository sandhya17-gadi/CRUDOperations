package com.cg.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

@Entity
public class Employee implements Serializable {
	
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long employeeId;
	
	@Column(name="emp_FirstName")
	private String firstName;
	
	@Column(name="emp_LastName")
	private String lastName;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="salary")
	private double salary;
	
	//setters and getters
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	

}
