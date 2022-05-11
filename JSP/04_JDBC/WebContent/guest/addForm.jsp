<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- DB연결하고 GUEST 테이블에서 새로운 사번을 만들어 사번 항목에 설정 --%>
<%
	//JDBC 프로그램 사용해서 사번 구하기(사번: 가장큰사원번호 + 1111 자동생성)
	//JDBC 프로그램을 위한 변수 선언
	final String DRIVER = "oracle.jdbc.OracleDriver"; 
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	final String USER = "mystudy"; 
	final String PASSWORD = "mystudypw"; 
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	
	String sql = "SELECT NVL(MAX(SABUN),0) + 1111 AS SABUN FROM GUEST";
	int sabun = 0;
	
	try {
		//1. 드라이버 로딩
		Class.forName(DRIVER);
		//2. DB연결
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		//3. Statement 객체 생성(Connection 객체로 부터)
		pstmt = conn.prepareStatement(sql);
		//4. 쿼리실행
		rs = pstmt.executeQuery();
		if (rs.next()) {
			//sabun = rs.getInt(1); // 컬럼인덱스사용(인덱스번호 1부터 시작)
			sabun = rs.getInt("SABUN");
		}
		
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록</title>
</head>
<body>
	<h1>사원등록</h1>
	<form action="insert.jsp" method="get">
		<table>
			<tr>
				<th>사번</th>
				<td><input type="text" name="sabun" value="<%=sabun %>" readonly></td>
			</tr>
			<tr>
				<th>성명</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td><input type="number" name="pay"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="사원등록">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>









