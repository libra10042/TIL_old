package com.mystudy.jdbc_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
public class StudentCRUD {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public StudentCRUD() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(">> 드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	//Student 테이블에 있는 1개의 데이터 조회해서 화면 표시
	// ID값을 전달하면 데이터를 가져와서 화면에 표시
	public void dispData(String id) {
		try {
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement문 실행(SQL문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sql.append("  FROM STUDENT ");
			sql.append(" WHERE ID = ? ");
			
			//3-1. PreparedStatement 객체생성 <- Connection 객체로 부터
			pstmt = conn.prepareStatement(sql.toString());
			
			//3-2. ? (바인드변수)에 값 설정
			pstmt.setString(1, id);
			
			//3-3. SQL문 실행
			rs = pstmt.executeQuery();
			
			//4. SQL 실행 결과에 대한 처리
			//   -SELECT : 조회(검색) 데이타 결과 값에 대한 처리
			if (rs.next()) {
				System.out.print(rs.getString("ID") + "\t");
				System.out.print(rs.getString("NAME") + "\t");
				System.out.print(rs.getInt("KOR") + "\t");
				System.out.print(rs.getInt("ENG") + "\t");
				System.out.print(rs.getInt("MATH") + "\t");
				System.out.print(rs.getInt("TOT") + "\t");
				System.out.print(rs.getDouble("AVG"));
				System.out.println();
			} else {
				System.out.println("아이디 : " + id + " - 데이터 없음");
			}
			
		} catch (SQLException e) {
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
	
	//하나의 데이터를 조회해서 VO에 저장해서 리턴
	public StudentVO selectId(String id) {
		System.out.println("----> selectId() 시작");
		StudentVO stu = null;
		
		try {
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement문 실행(SQL문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sql.append("  FROM STUDENT ");
			sql.append(" WHERE ID = ? ");
			
			//3-1. PreparedStatement 객체생성 <- Connection 객체로 부터
			pstmt = conn.prepareStatement(sql.toString());
			
			//3-2. ? (바인드변수)에 값 설정
			pstmt.setString(1, id);
			
			//3-3. SQL문 실행
			rs = pstmt.executeQuery();
			
			//4. SQL 실행 결과에 대한 처리
			//   -SELECT : 조회(검색) 데이타 결과 값에 대한 처리
			if (rs.next()) {
				// StudentVO 타입 객체 생성하고 데이터 저장
				stu = new StudentVO(id, 
						rs.getString("NAME"), 
						rs.getInt("KOR"), 
						rs.getInt("ENG"), 
						rs.getInt("MATH"), 
						rs.getInt("TOT"), 
						rs.getDouble("AVG") );

			} else {
				System.out.println("아이디 : " + id + " - 데이터 없음");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			close(conn, pstmt, rs);
		}
		
		System.out.println("----> selectId() 끝");
		return stu;
	}
	private void close(Connection conn, 
			PreparedStatement pstmt, ResultSet rs) {
		//5. 클로징 처리에 의한 자원 반납
		try {
			if (rs != null) rs.close();
			System.out.println(">> ResultSet close");
		} catch (SQLException e) {}
		try {
			if (pstmt != null) pstmt.close();
			System.out.println(">> PreparedStatement close");
		} catch (SQLException e) {}
		try {
			if (conn != null) conn.close();
			System.out.println(">> Connection close");
		} catch (SQLException e) {}
	}
	private void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) pstmt.close();
			System.out.println(">> PreparedStatement close");
		} catch (SQLException e) {}
		try {
			if (conn != null) conn.close();
			System.out.println(">> Connection close");
		} catch (SQLException e) {}
	}
	
	//전체 데이터 조회 ArrayList에 담아서 리턴
	//하나의 데이터는 StudentVO에 담고, VO를 ArrayList에 담아서 리턴
	public List<StudentVO> selectAll() {
		List<StudentVO> list = new ArrayList<>();
		
		try {
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			//3. Statement문 실행(SQL문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID, NAME, KOR, ENG, MATH, TOT, AVG ");
			sql.append("  FROM STUDENT ");
			sql.append(" ORDER BY ID ");
			
			//3-1. PreparedStatement 객체생성 <- Connection 객체로 부터
			pstmt = conn.prepareStatement(sql.toString());
			
			//3-2. SQL문 실행
			rs = pstmt.executeQuery();
			
			//4. SQL문 실행결과 처리
			// DB데이터 하나를 StudentVO에 저장 + 리스트에 추가
			while (rs.next()) {
				//DB데이터 StudentVO에 저장
				StudentVO vo = new StudentVO(
						rs.getString("ID"), 
						rs.getString("NAME"), 
						rs.getInt("KOR"), 
						rs.getInt("ENG"), 
						rs.getInt("MATH"), 
						rs.getInt("TOT"), 
						rs.getDouble("AVG") );
				
				//VO를 리스트에 추가
				list.add(vo);
			}
			
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		
		return list;
	}
	
	//DB에 데이터 입력(INSERT)
	//모든 컬럼값을 받아서 입력 처리
	public int insertData(String id, String name, 
			int kor, int eng, int math, int tot, double avg) {
		return insertData(new StudentVO(id, name, kor, eng, math, tot, avg));
/*		
		int cnt = 0;
		//(실습) DB연결하고 전달받은 데이터를 DB에 입력처리(입력건수 리턴)
		try {
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement문 실행(SQL문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO STUDENT ");
			sql.append("       (ID, NAME, KOR, ENG, MATH, TOT, AVG) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
			System.out.println("INSERT SQL : " + sql.toString());
			
			pstmt = conn.prepareStatement(sql.toString()); //SQL문 전달해서 준비
			
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, math);
			pstmt.setInt(6, tot);
			pstmt.setDouble(7, avg);
			
			cnt = pstmt.executeUpdate(); //SQL문 실행 : INSERT,UPDATE,DELETE - executeUpdate()
		} catch (SQLException e) {
			cnt = -1;
			//e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return cnt;
*/		
	}
	
	//DB에 데이터 입력(INSERT) : StudentVO 타입 값 전달받아 입력처리
	public int insertData(StudentVO student) {
		int cnt = 0;
		//(실습) DB연결하고 전달받은 데이터를 DB에 입력처리(입력건수 리턴)
		try {
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement문 실행(SQL문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO STUDENT ");
			sql.append("       (ID, NAME, KOR, ENG, MATH, TOT, AVG) ");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
			System.out.println("INSERT SQL : " + sql.toString());
			
			pstmt = conn.prepareStatement(sql.toString()); //SQL문 전달해서 준비
			
			pstmt.setString(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setInt(3, student.getKor());
			pstmt.setInt(4, student.getEng());
			pstmt.setInt(5, student.getMath());
			pstmt.setInt(6, student.getTot());
			pstmt.setDouble(7, student.getAvg());
			
			cnt = pstmt.executeUpdate(); //SQL문 실행 : INSERT,UPDATE,DELETE - executeUpdate()
		} catch (SQLException e) {
			cnt = -1;
			//e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}		
		return cnt;
	}
	
	//수정(UPDATE) : StudentVO 데이터를 받아서 수정(ID 제외한 모든 데이터 수정)
	public int updateData(StudentVO student) {
		System.out.println(">> updateData() 시작");
		int result = 0;
		//(실습)DB연결하고 전달받은 VO 데이터와 일치하는 ID 데이터를 수정
		try {
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement문 실행(SQL문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE STUDENT ");
			sql.append("   SET NAME = ? ");
			sql.append("     , KOR = ? ");
			sql.append("     , ENG = ? ");
			sql.append("     , MATH = ? ");
			sql.append("     , TOT = ? ");
			sql.append("     , AVG = ? ");
			sql.append(" WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			int idx = 1;
			pstmt.setString(idx++, student.getName());
			pstmt.setInt(idx++, student.getKor());
			pstmt.setInt(idx++, student.getEng());
			pstmt.setInt(idx++, student.getMath());
			pstmt.setInt(idx++, student.getTot());
			pstmt.setDouble(idx++, student.getAvg());
			
			//where절 매칭값
			pstmt.setString(idx++, student.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		
		System.out.println(">> updateData() 끝");
		return result;
	}
	//삭제(DELETE) : ID값을 전달받아 데이터 삭제
	public int deleteData(String id) {
		int result = 0;
		try {
			//2. DB연결  - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", 
					"mystudy", "mystudypw");
			
			//3. Statement문 실행(SQL문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM STUDENT WHERE ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			
			//where절 매칭값
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return result;
	}
	//삭제(DELETE) : StudentVO 전달받아 데이터 삭제
	public int deleteData(StudentVO student) {
		return deleteData(student.getId());
	}
	
	//=======================================
	//----- INSERT 실습 ------------
	//(실습) StudentVO 데이터를 전달받아서 입력 처리(TOT, AVG 계산 후 입력)
	
	//----- UPDATE 실습
	//(실습) ID, NAME 값을 받아서 ID로 조회하고, NAME 수정
	//(실습) ID, KOR, ENG, MATH 값을 받아서 ID로 찾고
	//       KOR, ENG, MATH, TOT, AVG 값 수정(TOT, AVG 계산 처리)
	//(실습) ID 받아서 TOT, AVG 수정 처리(TOT, AVG 재계산 처리)
	
	//----- DELETE 실습
	//(실습) 이름 받아서 삭제
	
	//----- SELECT 실습
	//(실습) 이름으로 조회 - 이름 중복 가능성 있음(List, Set, Map 사용)
}















