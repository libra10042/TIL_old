package com.mystudy.ojdbc2_statement;

import java.sql.Connection;
import java.sql.DriverManager;
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
		Statement stmt = null;
		
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement문 실행(SQL문 실행)
			//3-1. Connection 객체로부터 Statement 객체 생성
			stmt = conn.createStatement();
			
			//3-2. 사용할 SQL문 작성
			String id = "A1111";
			String name = "홍경래";
			int kor = 100;
			int eng = 90;
			int math = 80;
			int tot = kor + eng + math;
			double avg = tot * 100 / 3 / 100.0;
			
			String sql = ""
					+ "INSERT INTO STUDENT (ID, NAME, KOR, ENG, MATH, TOT, AVG) \n"
					+ "VALUES ('" + id + "', '" + name + "', " + kor + ", " 
					+ eng + ", " + math + ", " + tot + ", " + avg + ")";
			System.out.println("sql : " + sql);
			
			//3-3. Statement 객체를 사용해서 SQL문 실행
			int result = stmt.executeUpdate(sql);
			
			//4. SQL 실행 결과에 대한 처리
			//   -SELECT : 조회(검색) 데이타 결과 값에 대한 처리
			//   -INSERT, UPDATE, DELETE : int값(건수) 처리
			System.out.println("처리건수 : " + result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			try {
				if (stmt != null)stmt.close();
				System.out.println(">> Statement close 성공");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
				System.out.println(">> Connection close 성공");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}









