package com.main.daohelperservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.daohelper.DaoHelper;
import com.main.daohelper.DaoHelperImpl;


@Service
public class DaoHelperServiceImpl implements DaoHelper {
	

	@Autowired
	DaoHelperImpl DaoHelperImpl; 
	
	@Override
	public int getNumOfRecords() {
		
		
		int numOfRecords = DaoHelperImpl.getNumOfRecords(); 
		
		return numOfRecords;
	}

	@Override
	public void truncateTable() {
		
		DaoHelperImpl.truncateTable();
		
	}

}
