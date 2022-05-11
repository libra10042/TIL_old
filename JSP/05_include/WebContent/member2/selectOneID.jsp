<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 아이디값으로 DB에서 데이터 조회 후 화면 표시
	- 없으면 : 데이터 없음 메시지 표시
--%>
<%
	//1. 전달받은 파라미터값 추출(id)
	String id = request.getParameter("id");
	
	//2. DB연동작업(id로 데이터 조회)
	final String DRIVER = "oracle.jdbc.OracleDriver"; 
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	final String USER = "mystudy"; 
	final String PASSWORD = "mystudypw"; 
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		//1. 드라이버 로딩
		Class.forName(DRIVER);
		//2. DB연결
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		String sql = "";
		sql += "SELECT IDX, ID, PWD, NAME, AGE ";
		sql += "     , NVL(ADDRESS,'주소없음') AS ADDRESS, REG ";
		sql += "     , TO_CHAR(REG, 'YYYY/MM/DD') REG2 ";
		sql += "  FROM MEMBER2 ";
		sql += " WHERE ID = ? ";
		//3. Statement 객체 생성(Connection 객체로 부터)
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		//4. 쿼리실행
		rs = pstmt.executeQuery();	
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB연동</title>
<script type="text/javascript" src="includee/event.js"></script>
</head>
<body>
	<%@ include file="includee/menu.jspf" %>
	<h1>검색(ID) 결과</h1>
	<table border>
	<thead>
		<tr>
			<th>번호</th><th>아이디</th><th>패스워드</th>
			<th>이름</th><th>나이</th><th>주소</th><th>날짜</th>
		</tr>
	</thead>
	<tbody>
<%
		if (rs.next()) { %>
		<tr>	
			<td><%=rs.getInt("IDX") %></td>
			<td><%=rs.getString("ID") %></td>
			<td><%=rs.getString("PWD") %></td>
			<td><%=rs.getString("NAME") %></td>
			<td><%=rs.getInt("AGE") %></td>
			<td><%=rs.getString("ADDRESS") %></td>
			<%-- <td><%=rs.getDate("REG") %></td> --%>
			<td><%=rs.getString("REG2") %></td>
		</tr>
<%      } else { %>
		<tr>
			<td colspan="7">아이디(<%=id %>) 데이터가 없습니다</td>
		</tr>
<%      } %>
	</tbody>
	</table>
</body>
</html>

<%
	} catch (Exception e) {
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







