package com.ideas2it.employeeProject.model;

import java.util.Date;

/**
 * Employee Pojo Class
 *
 * @version  2.0 23-02-2021
 * @author  Riyas Ahamed
 */
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private int salary;
    private long mobileNumber;
    private Date dateOfBirth;
    
    public Employee(int employeeId, String firstName, String lastName, int salary, long mobileNumber, Date dateOfBirth) {
	this.employeeId = employeeId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.salary = salary;
	this.mobileNumber = mobileNumber;
	this.dateOfBirth = dateOfBirth;
    }

    public int getEmployeeId() {
	return employeeId;
    }

    public void setEmployeeId(int employeeId) {
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

    public int getSalary() {
	return salary;
    }

    public void setSalary(int salary) {
	this.salary = salary;
    }

    public long getMobileNumber() {
	return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
    }

    public Date getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
	    return "EmployeeId = " + employeeId +
	            "\n FirstName = " + firstName + 
		    "\n LastName = " + lastName + 
		    "\n DateOfBirth = " + dateOfBirth +
		    "\n Salary = " + salary + 
		    "\n MobileNumber = " + mobileNumber ;
		    
    }
}

