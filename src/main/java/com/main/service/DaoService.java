package com.main.service;

import java.util.List;

import com.main.dto.StudentDto;
import com.main.student.Student;

//interface will make calls to the database
//same as dao methods

public interface DaoService {
	
	public List<Student> fetchStudents();

	public int addStudent(StudentDto student); 

}
