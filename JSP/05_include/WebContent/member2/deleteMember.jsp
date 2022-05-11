<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 DB에 삭제하고 전체데이터 보기 페이지로 이동 --%>
<%
	//1. 전달받은 데이터(파라미터) 추출
	String id = request.getParameter("id");
	
	//2. DB에 입력 처리
	final String DRIVER = "oracle.jdbc.OracleDriver"; 
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	final String USER = "mystudy"; 
	final String PASSWORD = "mystudypw"; 
		
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
		
		String sql = "DELETE FROM MEMBER2 WHERE ID = ?";
		//3. Statement 객체 생성(Connection 객체로 부터)
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		//4. 쿼리실행(INSERT, UPDATE, DELETE)
		result = pstmt.executeUpdate();
		
		//페이지전환 : 정상삭제 처리 후 페이지 이동(selectAll.jsp)
		response.sendRedirect("selectAll.jsp");
		
	} catch(Exception e) {
		//예외처리
		response.sendRedirect("error.jsp");
	} finally {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
%>
