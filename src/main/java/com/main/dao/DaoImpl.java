package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.main.dto.StudentDto;
import com.main.rowmapper.StudentRowMapper;
import com.main.student.Student;

public class DaoImpl implements Dao {
	
	@Autowired
	JdbcTemplate JdbcTemplate; 

	@Override
	public List<Student> fetchStudents() {
		
		String sqlString = "Select * From info.students";
		List<Student> list = JdbcTemplate.query(sqlString, new StudentRowMapper());

		return list;
	}
	
	
	@Override
	public Student fetchStudent(int id) {
		
		String sqlString = "Select * From info.students WHERE id=?";
		
		Student student = JdbcTemplate.queryForObject(sqlString, new StudentRowMapper(), id);
		
		return student;
	}

	
	@Override
	public int addStudent(StudentDto student) {
		
		String sqlString = "INSERT INTO info.students (name, school) VALUES(?,?)";
		Object[] args = {student.getName(), student.getSchool()};
		int num = JdbcTemplate.update(sqlString, args);
		return num; 
	}


	@Override
	public int updateStudent(Student student) {
		String sqlString = "Update info.students SET name=?, school=? WHERE id=?";
		
		Object[] args = {student.getName(), student.getSchool(), student.getId()}; 
		
		int recordsUpdated = JdbcTemplate.update(sqlString, args);
		
		return recordsUpdated;
	}











	
}
