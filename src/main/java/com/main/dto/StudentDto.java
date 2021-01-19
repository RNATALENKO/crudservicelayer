package com.main.dto;


/* use this class to only transfer data from front end to back end
 * make sure to auto increment the id to give a new unique id to every input
 *
 */

public class StudentDto {
	
	private int id; //because it's int type, default value is 0 when nothing is assigned, null for Integer
	private String name; 
	private String school;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", school=" + school + "]";
	}
	

	

}
