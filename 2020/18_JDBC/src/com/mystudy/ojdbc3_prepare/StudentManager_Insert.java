package com.mystudy.ojdbc3_prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Insert {

	public static void main(String[] args) {
		//JDBC를 이용한 DB 프로그래밍 절차 
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		//1. JDBC 드라이버 로딩
		//2. DB연결  - Connection 객체 생성 <- DriverManager
		//3. Statement문 실행(SQL문 실행)
		//4. SQL 실행 결과에 대한 처리
		//   -SELECT : 조회(검색) 데이타 결과 값에 대한 처리
		//   -INSERT, UPDATE, DELETE : int값(건수) 처리
		//5. 클로징 처리에 의한 자원 반납
		//------------------------------------
		
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement문 실행(SQL문 실행)
			//3-1. Connection 객체로부터 PreparedStatement 객체 생성
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO STUDENT ");
			sql.append("       (ID, NAME, KOR, ENG, MATH) ");
			sql.append("VALUES (?, ?, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			//3-2. ?(바인드변수) 위치에 값 대입
			String id = "P1111";
			String name = "P테스트";
			int kor = 100;
			int eng = 90;
			int math = 80;
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, math);
			
			//3-3. SQL문 실행
			int result = pstmt.executeUpdate();
			
			//4. SQL 실행결과에 대한 처리
			System.out.println("처리건수 : " + result);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			try {
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}









