package com.code.data;

public class Employee {

	String firstName;
	String lastName;

	public Employee( String firstName, String lastName ) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override public String toString() {
		return "Employee{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}