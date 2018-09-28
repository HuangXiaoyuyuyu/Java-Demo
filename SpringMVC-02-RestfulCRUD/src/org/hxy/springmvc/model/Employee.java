package org.hxy.springmvc.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Past;
import java.util.Date;

public class Employee {

	private Integer id;
	@NotEmpty
	private String lastName;

	@Email
	private String email;
	//1 male, 0 female
	private Integer gender;
	
	private Department department;

	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;

	@NumberFormat(pattern = "#,###,###.#")
	private float salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String lastName, String email, Integer gender,
					Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", department=" + department +
				", birth=" + birth +
				", salary=" + salary +
				'}';
	}
}
