package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.Dao;
import com.main.dto.StudentDto;
import com.main.student.Student;


//this class will write the logic of the database and talk to the database, for example if you have to sort, send email, etc.
//holds business criteria


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

	@Override
	public StudentDto fetchStudent(int id) {
		
		//execute db call, convert student object returned from call to dao, return dao
		StudentDto studentDto = new StudentDto(); 

		Student student = dao.fetchStudent(id);
		String name = student.getName(); 
		String school = student.getSchool();  
		int userId = student.getId(); 
		
		studentDto.setId(userId);
		studentDto.setName(name);
		studentDto.setSchool(school);
		
		return studentDto;
	}

	@Override
	public int updateStudent(StudentDto studentDto) {
		
		//convert studentDto to student
		Student student = new Student(); 
		student.setId(studentDto.getId()); 
		student.setName(studentDto.getName()); 
		student.setSchool(studentDto.getSchool());
		
		//execute the the db call
		int updatedRecords = dao.updateStudent(student);
		
		return updatedRecords;
	}


	
}
