<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex11_resp_redirect-2.jsp</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	System.out.println(">> ex11_resp_redirect-2.jsp "
			+ "id: " + id + ", pwd: " + pwd);
%>
	<h2>[ ex11_resp_redirect-2.jsp 페이지 ]</h2>
	<hr>
	<h2>아이디 : <%=id %></h2>
	<h2>암호 : <%=pwd %></h2>	
</body>
</html>





