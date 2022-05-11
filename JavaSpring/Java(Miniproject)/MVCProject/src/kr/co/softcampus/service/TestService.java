package kr.co.softcampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.dao.TestDAO;

@Service
public class TestService {

	@Autowired
	private TestDAO dao;
	
	public String testMethod(){
		
		String str = dao.testDaoMethod();
		
		return str;
	}
	
	
	
}
