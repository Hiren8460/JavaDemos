package com.management.employee;

import java.util.Date;

public class Employee {
	
	private int id;
	private String firstname;
	private String lastname;
	private String date;
	private String address;
	private byte gender;
	private double salary;
	private  byte skill[];
	
	public Employee(int id, String firstname, String lastname, String date, String address, byte gender,
			double salary) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
		this.address = address;
		this.gender = gender;
		this.salary = salary;
	}

	public Employee(String firstname, String lastname, String date, String address, byte gender, double salary) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.date = date;
		this.address = address;
		this.gender = gender;
		this.salary = salary;
	}

	public Employee(String firstname, String lastname, String date, String address, byte gen, double salary,
			byte[] skills) {
		
		this.firstname=firstname;
		this.lastname=lastname;
		this.date=date;
		this.address=address;
		this.date=date;
		
		this.gender=gen;
		
		this.salary=salary;
	
		this.skill=skills;
		
		// TODO Auto-generated constructor stub
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}


	
	public Employee(int id, String firstname, String lastname, String date, String address, byte gen,
			double salary, byte[] skills) {
		// TODO Auto-generated constructor stub
		
		this.id = id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.date=date;
		this.address=address;
		this.date=date;
		
		this.gender=gen;
		
		this.salary=salary;
	
		this.skill=skills;
		
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public byte[] getSkill() {
		return skill;
	}

	public void setSkill(byte[] skill) {
		this.skill = skill;
	}

	
	
	
	
	
	
	
}