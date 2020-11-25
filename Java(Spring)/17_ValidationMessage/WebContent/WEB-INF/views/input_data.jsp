<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>input_data</h1>
	<form action='input_pro' method='post'><br/>
		data1 : <input type='text' name='data1' /><br/>
		<spring:hasBindErrors name="dataBean1">
			<c:if test="${errors.hasFieldErrors('data1') }">
				<spring:message code="${errors.getFieldError('data1').codes[0] }"/><br/>
			</c:if>
		</spring:hasBindErrors>
		data2 : <input type='text' name='data2' /><br/>
		<spring:hasBindErrors name="dataBean1">
			<c:if test="${errors.hasFieldErrors('data2') } ">
				<spring:message code="${errors.getFieldError('data2').codes[0] }" /><br/>
			</c:if>
		</spring:hasBindErrors>
		
		<button type='submit'>확인</button>
	</form>
</body>
</html>