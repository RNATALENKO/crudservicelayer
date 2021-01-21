package com.main.daohelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DaoHelperImpl implements DaoHelper {
	
	@Autowired
	JdbcTemplate JdbcTemplate;

	@Override
	public int getNumOfRecords() {
		
		String sqlString = "SELECT COUNT(*) FROM info.students";
		
		int numOfRecords = JdbcTemplate.queryForObject(sqlString, Integer.class);
		return numOfRecords;
	}
	
	

	@Override
	public void truncateTable() {
		
		String sqlString = "TRUNCATE TABLE info.students";
		
		JdbcTemplate.execute(sqlString);
		
	}

}
