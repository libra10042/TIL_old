package kr.co.softcampus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	
	@Autowired
	private TestDAO dao;
	
	public String testDaoMethod() {
		
		String str = dao.testDaoMethod();
		
		
		return "str";
	}
	
}
