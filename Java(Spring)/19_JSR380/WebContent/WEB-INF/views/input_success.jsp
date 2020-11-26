<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>input_success</h1>
	
	<form:form action='input_pro' modelAttribute="dataBean1" method='post'>
	
		data1 : <form:input path="data1" type='text'/><br/>
				<form:errors path='data1' /><br/>
				
				
	
		<form:button type='submit'>확인</form:button>
	</form:form>
	
</body>
</html>