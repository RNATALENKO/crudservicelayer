package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.Dao;
import com.main.dto.StudentDto;
import com.main.student.Student;


//this class will write the logic of the database and talk to the database, for example if you have to sort, 


@Service
public class DaoServiceImpl implements DaoService {
	
	@Autowired
	Dao dao;

	@Override
	public List<Student> fetchStudents() {
		
		List<Student> studentList = dao.fetchStudents(); //call to db
		
		return studentList;
	}

	@Override
	public int addStudent(StudentDto student) {
		
		int addedNum= dao.addStudent(student);
		
		return addedNum;
	} 
	
}
