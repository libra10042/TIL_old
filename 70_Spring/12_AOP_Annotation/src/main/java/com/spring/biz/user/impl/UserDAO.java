package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

@Repository
public class UserDAO {
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	
	public UserDAO() {
		System.out.println(">> UserDAO() 실행(객체생성)");
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC로 getUser() 실행");
		UserVO user = null;

		conn = JDBCUtil.getConnection();
		if (conn == null) return null;
		try {
			//DELETE FROM BOARD WHERE SEQ = ?
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				/*
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				*/
				user = new UserVO(
						rs.getString("ID"), 
						rs.getString("PASSWORD"), 
						rs.getString("NAME"), 
						rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}		
		
		return user;
	}
}









