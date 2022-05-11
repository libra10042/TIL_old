package com.mystudy.ojdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentManager_Select {

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
		//==========================================

		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		//1. JDBC 드라이버 로딩
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> 드라이버 로딩 성공~~~");
		} catch (ClassNotFoundException e) {
			System.out.println("[예외] 드라이버 로딩 실패!!!");
			e.printStackTrace();
		}

		//2. DB연결  - Connection 객체 생성 <- DriverManager
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", 
					"mystudy", "mystudypw");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3. Statement문 실행(SQL문 실행)
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//3-1. Connection 객체로부터 Statement 객체 생성 
			stmt = conn.createStatement();
			
			//3-2. Statement 객체 사용할 SQL 작성
			String sql = ""
					+ "SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG "
					+ "  FROM STUDENT"
					+ " ORDER BY NAME";
			
			//3-3. Statement 객체 사용 SQL 실행
			rs = stmt.executeQuery(sql); //SELECT : executeQuery() 사용
			
			//4. SQL 실행 결과에 대한 처리
			//   -SELECT : 조회(검색) 데이타 결과 값에 대한 처리
			//   -INSERT, UPDATE, DELETE : int값(건수) 처리
			System.out.println(">> SELECT  결과 처리(화면출력) ------");
/*			
			while (rs.next()) {
				System.out.print(rs.getString("ID") + "\t");
				System.out.print(rs.getString("NAME") + "\t");
				System.out.print(rs.getInt("KOR") + "\t");
				System.out.print(rs.getInt("ENG") + "\t");
				System.out.print(rs.getInt("MATH") + "\t");
				System.out.print(rs.getInt("TOT") + "\t");
				System.out.println(rs.getDouble("AVG"));
			}
*/
			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				sb.append(rs.getString("ID") + "\t");
				sb.append(rs.getString("NAME") + "\t");
				sb.append(rs.getInt("KOR") + "\t");
				sb.append(rs.getInt("ENG") + "\t");
				sb.append(rs.getInt("MATH") + "\t");
				sb.append(rs.getInt("TOT") + "\t");
				sb.append(rs.getDouble("AVG"));
				System.out.println(sb.toString());
				
				sb.setLength(0); //저장된 문자열 삭제 처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//5. 클로징 처리에 의한 자원 반납(객체 생성 순서와 역순으로 진행)		
		System.out.println("--- main() 끝 ---");
		try {
			if (rs != null) rs.close();
			System.out.println(">> ResultSet close 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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













