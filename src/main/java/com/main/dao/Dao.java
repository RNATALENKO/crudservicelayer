package com.main.dao;

import java.util.List;

import com.main.dto.StudentDto;
import com.main.student.Student;

public interface Dao {
	
	
	public List<Student> fetchStudents();
	
	public Student fetchStudent(int id); 

	public int addStudent(StudentDto student); 

	int updateStudent(Student student);

	public int deleteStudent(int id);
	
	
	
	
	

}
