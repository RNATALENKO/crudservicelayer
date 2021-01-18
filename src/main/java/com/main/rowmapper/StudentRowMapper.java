package com.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.main.student.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student(); 
		
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setSchool(rs.getString("school"));
		
		return student;
	}

}
