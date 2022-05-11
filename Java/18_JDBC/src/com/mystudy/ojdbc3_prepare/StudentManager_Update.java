package com.mystudy.ojdbc3_prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentManager_Update {

	public static void main(String[] args) {
		//(실습) PreparedStatement 사용해서 수정 작업
		// 수정대상 : ID - DB에 있는 데이터 대상
		// 이름: 홍길동, 국어: 100, 영어: 90, 수학: 81 으로 수정처리

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
			sql.append("UPDATE STUDENT ");
			sql.append("   SET NAME = ? "); // 1 바인드변수의 위치번호
			sql.append("     , KOR = ? ");   // 2
			sql.append("     , ENG = ? ");   // 3
			sql.append("     , MATH = ? ");  // 4
			sql.append(" WHERE ID = ? ");    // 5
			pstmt = conn.prepareStatement(sql.toString());
			
			//3-2. ?(바인드변수) 위치에 값 대입
			String id = "A3333";
			String name = "홍길동P1111";
			int kor = 99;
			int eng = 88;
			int math = 77;
			
			pstmt.setString(1, name);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, math);
			pstmt.setString(5, id);
			
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
