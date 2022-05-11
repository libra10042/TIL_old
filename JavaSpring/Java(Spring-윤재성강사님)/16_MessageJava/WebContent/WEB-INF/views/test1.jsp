<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<H1>test1</H1>
	<h3>aaa.a1 : <spring:message code='aaa.a1' /></h3>
	<h3>bbb.b1 : <spring:message code='bbb.b1' /></h3>
	
	
	<h3>aaa.a2 : <spring:message code='aaa.a2' arguments="${args }" /></h3>
	
	<h3>aaa.a3 : <spring:message code='aaa.a3' /></h3>
</body>
</html>