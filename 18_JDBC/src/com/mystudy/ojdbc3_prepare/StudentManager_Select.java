package com.mystudy.ojdbc3_prepare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement문 실행(SQL문 실행)
			//3-1. Connection 객체로 부터 PreparedStatement 객체생성
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sb.append("  FROM STUDENT ");
			sb.append(" WHERE ID = ? "); // ? : 바인드 변수 위치 표시 부호
			pstmt = conn.prepareStatement(sb.toString());
			
			//3-2. ?(바인드변수) 가 있으면 값 대입 시키기
			String id = "A3333";
			pstmt.setString(1, id);	
			
			//3-3. Statement(PreparedStatement) 사용 SQL 실행
			rs = pstmt.executeQuery();
			
			//4. SQL 실행 결과에 대한 처리
			//   -SELECT : 조회(검색) 데이타 결과 값에 대한 처리
			while (rs.next()) {
				sb.setLength(0);
				sb.append(rs.getString("ID")).append("\t");
				sb.append(rs.getString("NAME")).append("\t");
				sb.append(rs.getInt("KOR")).append("\t");
				sb.append(rs.getInt("ENG")).append("\t");
				sb.append(rs.getInt("MATH")).append("\t");
				sb.append(rs.getInt("TOT")).append("\t");
				sb.append(rs.getDouble("AVG"));
				
				System.out.println(sb.toString());
			}
			System.out.println(">> 데이터 정상 조회 완료");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			try {
				if (rs != null) rs.close();
			} catch (SQLException e) {}
			try {
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {}
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {}
		}
		

	}

}








