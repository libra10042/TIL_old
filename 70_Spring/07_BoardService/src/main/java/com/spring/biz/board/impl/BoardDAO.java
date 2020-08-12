package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;

public class BoardDAO {
	//JDBC 관련 변수(필드)
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//SQL문
	private final String BOARD_INSERT
		= "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT) "
		+ "VALUES ((SELECT NVL(MAX(SEQ),0)+1 FROM BOARD), ?, ?, ?)";
	private final String BOARD_UPDATE
		= "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
	private final String BOARD_DELETE
		= "DELETE FROM BOARD WHERE SEQ = ?";
	private final String BOARD_GET
		= "SELECT * FROM BOARD WHERE SEQ = ?";
	private final String BOARD_LIST
		= "SELECT * FROM BOARD ORDER BY SEQ DESC";
	
	public BoardDAO() {
		System.out.println(">> BoardDAO() 객체 생성");
	}
	
	//글 입력(실습)
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 실행");
		
	}
	
	//글 수정(실습)
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 실행");
		
	}
	
	//글 삭제(실습)
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 실행");
		
	}
	
	//글 상세조회(데이터 하나 조회)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 실행");
		BoardVO board = null;
		
		conn = JDBCUtil.getConnection();
		if (conn == null) return null;
		try {
			//DELETE FROM BOARD WHERE SEQ = ?
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		
		return board;
	}
	
	//글 전체 조회(실습)
	public List<BoardVO> getBoardList() {
		System.out.println("===> JDBC로 getBoardList() 실행");
		List<BoardVO> list = null;
		
		return list;
	}
}










