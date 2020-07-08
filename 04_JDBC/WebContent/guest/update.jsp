<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--(실습) 전달받은 데이터를 사용해서 DB 데이터 수정 처리 
	수정할데이터 : 성명, 날짜(sysdate), 금액
	정상처리후 : list.jsp 이동
	예외발생시 : 현재페이지 보여주기(상세보기, 목록보기)
--%>    
<%
	//전달받은 파라미터 값 확인(추출)
	int sabun = Integer.parseInt(request.getParameter("sabun"));
	String name = request.getParameter("name");
	int pay = 0;
	try {
		pay = Integer.parseInt(request.getParameter("pay"));
	} catch(NumberFormatException e) {
%>
		<script>
			alert("금액에 숫자가 아닌 문자가 입력되었습니다.\n확인 후 다시 입력하세요");
			history.back(); //이전페이지로 이동
		</script>
<%
		return; //서비스 메소드 실행종료
	}
	//DB 데이터 수정
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
		
		String sql = "";
		sql += "UPDATE GUEST ";
		sql += "   SET NAME = ?, PAY = ? ";
		sql += " WHERE SABUN = ? ";
		//3. Statement 객체 생성(Connection 객체로 부터)
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, pay);
		pstmt.setInt(3, sabun);
		
		//4. 쿼리실행(INSERT, UPDATE, DELETE)
		result = pstmt.executeUpdate();
	} catch(Exception e) {
		e.printStackTrace();
		result = -999;
	} finally {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	if (result == 0) {//SQL문장은 정상실행 되었으나 데이터 수정 안됨
%>
		<script>
			alert("[수정실패] 대상이 없어서 수정처리하지 못했습니다."
					+"\n목록페이지로 이동합니다");
			location.href = "list.jsp";
		</script>
<%
	} else if (result > 0) { //SQL문장 정상실행 + 데이터수정 처리
%>
		<script>
			alert("[수정완료] 수정처리 완료하고 목록페이지로 이동합니다");
			location.href = "list.jsp";
		</script>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 수정 실패</title>
</head>
<body>
	<h1>사원 수정 실패</h1>
	<p>수정처리를 하지 못했습니다.<br>
	[ 상세페이지로 이동] 클릭해서 다시 작업하세요.
	담당자(8282)에게 연락하세요.
	</p>
	<a href="detail.jsp?idx=<%=sabun %>">상세페이지로 이동</a>
	<a href="list.jsp">전체목록 보기</a>
</body>
</html>





