<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--(실습) 전달받은 데이터를 이용해서 DB에 입력처리 
	정상입력 : list.jsp 페이지로 이동
	예외발생 : 현재 페이지 보여주기 
--%>
<%
	//1. 파라미터 값 추출
	int sabun = Integer.parseInt(request.getParameter("sabun"));
	String name = request.getParameter("name");
	int pay = 0;
	int result = 0; //입력결과 확인용
	try {
		pay = Integer.parseInt(request.getParameter("pay"));
		result = insert(sabun, name, pay);
	} catch(NumberFormatException e) {
		System.out.println(">> 급여항목에 잘못된 값이 입력되었습니다.");
	}

	
	//3. 페이지 이동처리(list.jsp)
	if (result > 0) { //데이터 정상 입력 처리시
		response.sendRedirect("list.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 등록 실패</title>
</head>
<body>
	<h1>사원 등록 실패</h1>
	<p>입력처리를 하지 못했습니다.<br>
	[ 입력페이지로 이동] 클릭해서 다시 작업하세요.
	담당자(8282)에게 연락하세요.
	</p>
	<a href="addForm.jsp">입력페이지로 이동</a>
	<a href="list.jsp">전체목록 보기</a>
</body>
</html>
<%!
	//선언부(declaration) : 클래스의 필드영역에 추가되는 코드 
	//JDBC 프로그램을 위한 변수 선언(필드영역에 선언)
	final String DRIVER = "oracle.jdbc.OracleDriver"; 
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	final String USER = "mystudy"; 
	final String PASSWORD = "mystudypw"; 
	
	private int insert(int sabun, String name, int pay) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	
		
		int result = 0;
		//2. JDBC를 이용한 DB 입력 처리
		try {
			//1. 드라이버 로딩
			Class.forName(DRIVER);
			//2. DB연결
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "";
			sql += "INSERT INTO GUEST ";
			sql += "       (SABUN, NAME, NALJA, PAY) ";
			sql += "VALUES (?, ?, SYSDATE, ?)";
			//3. Statement 객체 생성(Connection 객체로 부터)
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			pstmt.setString(2, name);
			pstmt.setInt(3, pay);
			
			//4. 쿼리실행(INSERT, UPDATE, DELETE)
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
%>	








