package com.main.dao;

import java.util.List;

import com.main.dto.StudentDto;
import com.main.student.Student;

public interface Dao {
	
	
	public List<Student> fetchStudents();

	public int addStudent(StudentDto student); 
	

}
