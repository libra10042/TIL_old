<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//request, session의 속성에 데이터 저장하고 되돌아가기
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	System.out.println(">> param name: " + name + ", age: " + age);
	
	//session scope 에 저장
	session.setAttribute("attr_name", name);
	session.setAttribute("attr_age", age);
	//session scope 에 저장된 값 조회
	String attr_name = (String) session.getAttribute("attr_name");
	String attr_age = (String) session.getAttribute("attr_age");
	System.out.println(">>session attr_name : " + attr_name);
	System.out.println(">>session attr_age : " + attr_age);
	
	//-----------------------------------
	//request scope 에 저장
	request.setAttribute("req_name", name);
	request.setAttribute("req_age", age);
	String req_name = (String) request.getAttribute("req_name");
	String req_age = (String) request.getAttribute("req_age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ex01_sessionSet.jsp</h1>
	<h2>이름(param) : <%=name %></h2>
	<h2>나이(param) : <%=age %></h2>
	<hr>
	
	<h2>이름(session attr_name) : <%=attr_name %></h2>
	<h2>나이(session attr_age) : <%=attr_age %></h2>
	<hr>
	
	<h2>이름(request req_name) : <%=req_name %></h2>
	<h2>나이(request req_age) : <%=req_age %></h2>
	
<%
	response.sendRedirect("ex01_session.jsp");
%>	
	<br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>
















