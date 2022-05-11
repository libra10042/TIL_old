package com.mystudy.ojdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Delete {
	
	public static void main(String[] args) {
		//JDBC를 이용한 DB 프로그래밍 절차 ------------------------------
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		//1. JDBC 드라이버 로딩
		//2. DB연결  - Connection 객체 생성 <- DriverManager
		//3. Statement문 실행(SQL문 실행)
		//4. SQL 실행 결과에 대한 처리
		//   -SELECT : 조회(검색) 데이타 결과 값에 대한 처리
		//   -INSERT, UPDATE, DELETE : int값(건수) 처리
		//5. 클로징 처리에 의한 자원 반납
		//------------------------------------
		
		System.out.println("---- main() 시작 ---");
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		//1. JDBC 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외] 드라이버 파일 없음");
			//e.printStackTrace();
		}
		
		//2. DB연결  - Connection 객체 생성 <- DriverManager
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			System.out.println(">> DB 연결 성공!!!");
		} catch (SQLException e) {
			System.out.println("[예외] DB연결 실패~~~");
			e.printStackTrace();
		}
		
		//3. Statement문 실행(SQL문 실행)
		Statement stmt = null;
		try {
			//3-1. Connetion 객체로 부터 Statement 객체 생성
			stmt = conn.createStatement();
			
			//3-2. Statement 객체에서 사용할 SQL문 작성
			String sql = ""
					+ "DELETE FROM STUDENT WHERE ID = '1111'";
			
			//3-3. Statement 객체 사용해서 SQL문 실행
			//INSERT, UPDATE, DELETE : executeUpdate() 메소드 사용 실행
			//SELECT : executeQuery() 메소드 사용
			int result = stmt.executeUpdate(sql); //리턴값은 처리건수 
			
			//4. SQL 실행 결과에 대한 처리
			//   -SELECT : 조회(검색) 데이타 결과 값에 대한 처리
			//   -INSERT, UPDATE, DELETE : int값(건수) 처리
			System.out.println("처리건수 : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//5. 클로징 처리에 의한 자원 반납(객체 생성 역순으로 진행)
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
		
		System.out.println("---- main() 끝 ---");
	}

}







