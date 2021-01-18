package com.main.student;

/*
 * Do not use Pojo class as Dto in Model attribute, to prevent hackers from knowing your column name
 * create StudentDto if you're transferring data to a database. 
 * 
 */

public class Student {
	
	
	private int id; 
	private String name; 
	private String school;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", school=" + school + "]";
	} 
	
}
