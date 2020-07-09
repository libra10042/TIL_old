<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 - include</title>
</head>
<body>
<%--
	JSP액션 : JSP 페이지의 흐름 제어
	사용형태 : <jsp:액션명령></jsp:액션명령>
	           <jsp:액션명령 />
 --%>
	<h1>디렉티브/액션태그 - include</h1>
	<hr>
	<h2>디렉티브(지시어) - include</h2>
	<%@ include file="ex01_includee1.jspf" %>
	
	<hr>
	<%@ include file="ex01_includee2_param.jsp"%>
	
	<%-- ========================================== --%>
	<hr><hr>
	<h1>액션태그 - jsp:include</h1>
	<jsp:include page="ex01_includee1.jspf"></jsp:include>
	<hr>
	<jsp:include page="ex01_includee.jsp"></jsp:include>
	<hr>
	<h2>액션태그 - jsp:include(파라미터 전달)</h2>
	<jsp:include page="ex01_includee2_param.jsp">
		<jsp:param value="김유신" name="name"/>
		<jsp:param value="30" name="age"/>
	</jsp:include>
	
	<br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>



















