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
	public int addStudent(StudentDto student) {
		
		String sqlString = "INSERT INTO info.students (name, school) VALUES(?,?)";
		Object[] args = {student.getName(), student.getSchool()};
		int num = JdbcTemplate.update(sqlString, args);
		return num; 
	}

}
