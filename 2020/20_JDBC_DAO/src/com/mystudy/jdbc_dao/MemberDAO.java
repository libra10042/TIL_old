package com.mystudy.jdbc_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO, Dao : Data Access Object / Database Access Object
// 데이터(데이터베이스)와 연동해서 CRUD를 구현한 클래스
public class MemberDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver"; 
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private static final String USER = "mystudy"; 
	private static final String PASSWORD = "mystudypw"; 
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//드라이버 로딩 처리
	//static 초기화 구문
	static {
		try {
			Class.forName(DRIVER);
			System.out.println(">> 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] 드라이버 로딩 실패!!!");
		}
	}
	
	//CRUD 작업용 메소드 작성
	//SELECT : 테이블 전체 데이터 조회 - selectAll : List<MemberVO>
	public List<MemberVO> selectAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			//DB 연결 - Connection 객체생성(DB와 연결된) <- DriverManager 클래스 사용
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS ");
			sql.append("  FROM MEMBER ");
			sql.append(" ORDER BY ID");
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			
			//SQL 실행 결과에 대한 처리
			while (rs.next()) {
				/*
				MemberVO mvo = new MemberVO(
						rs.getString("ID"), 
						rs.getString("NAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("PHONE"), 
						rs.getString("ADDRESS") );
				list.add(mvo);
				*/
				list.add(new MemberVO(
						rs.getString("ID"), 
						rs.getString("NAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("PHONE"), 
						rs.getString("ADDRESS") ) );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//INSERT : VO 객체를 받아서 입력 - insertOne : int
	public int insertOne(MemberVO member) {
		int result = 0;
		try {
			//DB 연결 - Connection 객체생성(DB와 연결된) <- DriverManager 클래스 사용
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL 문장을 작성해서 Statement에 전달하고 SQL문 실행
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER ");
			sql.append("       (ID, NAME, PASSWORD, PHONE, ADDRESS) ");
			sql.append("VALUES (?, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			
			// ?(바인드변수)에 값 매칭 시키기
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddress());
			
			//SQL 실행 요청 - insert, update, delete : executeUpdate()
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			result = -1;
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}
		
		return result;
	}
	
	//(실습)SELECT : ID 값으로 데이터 조회 - selectOne : MemberVO
	public MemberVO selectOne(String id) {
		MemberVO mvo = null;
		
		try {
			//DB 연결 - Connection 객체생성(DB와 연결된) <- DriverManager 클래스 사용
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS ");
			sql.append("  FROM MEMBER ");
			sql.append(" WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			//SQL 실행 결과에 대한 처리
			if (rs.next()) {
				mvo = new MemberVO(
						rs.getString("ID"), 
						rs.getString("NAME"), 
						rs.getString("PASSWORD"), 
						rs.getString("PHONE"), 
						rs.getString("ADDRESS") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return mvo;
	}
	
	//SELECT : VO를 받아서 ID로 데이터 조회 - selectOne : MemberVO
	
	//(실습)UPDATE : VO 객체를 받아서 수정 - updateOne : int
	//         NAME, PASSWORD, PHONE, ADDRESS 값 수정
	public int updateOne(MemberVO member) {
		int result = 0;
		try {
			//DB 연결 - Connection 객체생성(DB와 연결된) <- DriverManager 클래스 사용
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL 문장을 작성해서 Statement에 전달하고 SQL문 실행
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE MEMBER ");
			sql.append("   SET NAME = ? ");
			sql.append("     , PASSWORD = ? ");
			sql.append("     , PHONE = ? ");
			sql.append("     , ADDRESS = ? ");
			sql.append(" WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			// ?(바인드변수)에 값 매칭 시키기
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getId());
			
			//SQL 실행 요청 - insert, update, delete : executeUpdate()
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			result = -1;
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}
		
		return result;
	}
	
	
	//UPDATE : ID, 패스워드 받아서 패스워드 수정
	//UPDATE : ID, PHONE 받아서 전화번호 수정
	//UPDATE : ID, 이메일 받아서 이메일 수정
	
	//DELETE : VO 객체를 받아서 삭제 - deleteOne : int
	//(실습)DELETE : 키값(id) 받아서 삭제 - deleteOne : int
	public int deleteOne(String id) {
		int result = 0;
		try {
			//DB 연결 - Connection 객체생성(DB와 연결된) <- DriverManager 클래스 사용
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			//SQL 문장을 작성해서 Statement에 전달하고 SQL문 실행
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM MEMBER ");
			sql.append(" WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			// ?(바인드변수)에 값 매칭 시키기
			pstmt.setString(1, id);
			
			//SQL 실행 요청 - insert, update, delete : executeUpdate()
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			result = -1;
		} finally {
			JDBC_Close.closeConnStmt(conn, pstmt);
		}
		
		return result;
	}	
	
	//(실습)로그인처리 : id, password 값을 받아서 동일한 데이터 있으면 true
	//            없으면 false 리턴
	// boolean checkIdPassword(id, password)
	public boolean checkIdPassword(String id, String password) {
		boolean isExist = false;
		
		try {
			//DB 연결 - Connection 객체생성(DB와 연결된) <- DriverManager 클래스 사용
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT COUNT(*) CNT");
			sql.append("  FROM MEMBER ");
			sql.append(" WHERE ID = ? AND PASSWORD = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			//SQL 실행 결과에 대한 처리
			if (rs.getInt("CNT") > 0) {
				isExist = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return isExist;
	}
	public String checkIdPassword2(String id, String password) {
		String name = null;
		
		try {
			//DB 연결 - Connection 객체생성(DB와 연결된) <- DriverManager 클래스 사용
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT NAME");
			sql.append("  FROM MEMBER ");
			sql.append(" WHERE ID = ? AND PASSWORD = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			//SQL 실행 결과에 대한 처리
			if (rs.next()) {
				name = rs.getString("NAME");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Close.closeConnStmtRs(conn, pstmt, rs);
		}
		
		return name;
	}
}




















