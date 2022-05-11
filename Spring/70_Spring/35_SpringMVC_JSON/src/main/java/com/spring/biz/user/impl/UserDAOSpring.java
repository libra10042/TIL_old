package com.spring.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

@Repository("userDAOSpring")
public class UserDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL문
	private final String USER_GET
	= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	public UserDAOSpring() {
		System.out.println(">> UserDAOSpring() 실행(객체생성)");
	}


	//유저 정보 불러오기
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring JDBC(JdbcTemplate)로 getUser()실행");
		
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
}