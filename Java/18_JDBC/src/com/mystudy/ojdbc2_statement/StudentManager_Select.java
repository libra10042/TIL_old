package com.mystudy.ojdbc2_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.BuildInfo;

public class StudentManager_Select {

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
		ResultSet rs = null;
		
		System.out.println("--- 데이터 조회 작업 시작 ---");
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
			
			String id = "A1111";
			StringBuilder sb = new StringBuilder();
			//columnIndex :   1   2     3    4    5     6    7
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sb.append("  FROM STUDENT ");
			sb.append(" WHERE ID = '" + id + "' ");
			System.out.println("SQL : " + sb);
			
			//3-2. SQL문 실행
			rs = stmt.executeQuery(sb.toString());
			
			//4. SQL 실행 결과에 대한 처리
/*			
			while (rs.next()) {
				// String 타입은 불변 데이터
				// 문자열 붙이기 하면 새로운 String 데이터 생성
				String str = "";
				str += rs.getString(1) + "\t";  
				str += rs.getString(2) + "\t";
				str += rs.getInt(3) + "\t";
				str += rs.getInt(4) + "\t";
				str += rs.getInt(5) + "\t";
				str += rs.getInt(6) + "\t";
				str += rs.getDouble(7);
				
				System.out.println(str);
			}
*/			
			while (rs.next()) {
				sb.setLength(0); //초기화 : 저장된 문자열 삭제
				int idx = 1;
				sb.append(rs.getString(idx++)).append("\t");
				sb.append(rs.getString(idx++)).append("\t");
				sb.append(rs.getInt(idx++)).append("\t");
				sb.append(rs.getInt(idx++)).append("\t");
				sb.append(rs.getInt(idx++)).append("\t");
				sb.append(rs.getInt(idx++)).append("\t");
				sb.append(rs.getDouble(idx++)).append("\t");
				
				System.out.println(sb.toString());
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			try {
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("--- 데이터 조회 작업 끝 ---");
	}

}










