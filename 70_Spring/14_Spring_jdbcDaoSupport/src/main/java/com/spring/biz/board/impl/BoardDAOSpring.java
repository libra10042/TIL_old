package com.spring.biz.board.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository("boardDAOSpring")
public class BoardDAOSpring extends JdbcDaoSupport {
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
	
	public BoardDAOSpring() {
		System.out.println(">> BoardDAOSpring() 객체 생성");
	}
	
	@Autowired // 파라미터 타입과 동일한 객체 주입하면서 메소드 실행
	public void setSuperDataSource(DataSource dataSource) {
		System.out.println(">>>> BoardDAOSpring.setSuperDataSource() 실행");
		System.out.println("dataSource : " + dataSource);
		super.setDataSource(dataSource);
	}
	
	//글등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 실행");
		
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		super.getJdbcTemplate().update(BOARD_INSERT, args);
	}
	
	//글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 실행");
		
		//Object[] args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
		//super.getJdbcTemplate().update(BOARD_UPDATE, args);
		
		super.getJdbcTemplate().update(BOARD_UPDATE, 
				vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	//글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 실행");
		
		super.getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
	
	// 글 하나 조회(상세조회)
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 실행");
		
		Object[] args = {vo.getSeq()};
		return super.getJdbcTemplate().queryForObject(BOARD_GET, 
				args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList() {
		System.out.println("===> Spring JDBC로 getBoardList() 실행");
		
		return super.getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}
}






