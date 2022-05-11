<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL : redirect</title>
</head>
<body>
	<h1>JSTL02_redirect.jsp</h1>
	<p>페이지전환 : redirect - 파라미터 값 전달 가능</p>
	<c:redirect url="JSTL02_resp.jsp">
		<c:param name="name" value="hong" />
		<c:param name="age">27</c:param>
		<c:param name="address">서울시 서초구</c:param>
	</c:redirect>
</body>
</html>











