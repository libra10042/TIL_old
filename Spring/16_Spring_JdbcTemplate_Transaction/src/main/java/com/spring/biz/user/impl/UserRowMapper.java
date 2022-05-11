package com.spring.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.biz.board.BoardVO;
import com.spring.biz.user.UserVO;

public class UserRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new UserVO(
				rs.getString("ID"), 
				rs.getString("PASSWORD"), 
				rs.getString("NAME"), 
				rs.getString("ROLE"));
	}



}











